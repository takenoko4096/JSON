package io.github.takenoko4096.mojangson;

import io.github.takenoko4096.mojangson.values.MojangsonArray;
import io.github.takenoko4096.mojangson.values.MojangsonCompound;
import io.github.takenoko4096.mojangson.values.MojangsonList;
import io.github.takenoko4096.mojangson.values.MojangsonStructure;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Objects;
import java.util.function.Function;

@NullMarked
public final class MojangsonPath {
    private final MojangsonPathNode<?, ?> root;

    MojangsonPath(MojangsonPathNode<?, ?> root) {
        this.root = root;
    }

    private <U> @Nullable U checkedAccess(MojangsonPathNode<?, ?> node, @Nullable MojangsonStructure structure, MojangsonPathReferer<MojangsonStructure, Object, @Nullable U> function) throws MojangsonPathUnableToAccessException {
        switch (node) {
            case MojangsonPathNode.ObjectKeyNode objectKeyNode -> {
                if (!(structure instanceof MojangsonCompound object)) {
                    throw new MojangsonPathUnableToAccessException("パスに対応する値へのアクセスに失敗しました: ノード " + node + " にアクセスするには " + structure + " がコンパウンドである必要があります");
                }
                return objectKeyNode.access(object, function::use);
            }
            case MojangsonPathNode.ArrayIndexNode arrayIndexNode -> {
                return switch (structure) {
                    case MojangsonList list -> arrayIndexNode.access(list, function::use);
                    case MojangsonArray<?, ?> array -> arrayIndexNode.access(array.listView(), function::use);
                    case null, default -> throw new MojangsonPathUnableToAccessException("パスに対応する値へのアクセスに失敗しました: ノード " + node + " にアクセスするには " + structure + " が配列またはリストである必要があります");
                };
            }
            case MojangsonPathNode.ObjectKeyCheckerNode objectKeyCheckerNode -> {
                if (!(structure instanceof MojangsonCompound object)) {
                    throw new MojangsonPathUnableToAccessException("パスに対応する値へのアクセスに失敗しました: ノード " + node + " にアクセスするには " + structure + " がコンパウンドである必要があります");
                }
                return objectKeyCheckerNode.access(object, function::use);
            }
            case MojangsonPathNode.ArrayIndexFinderNode arrayIndexFinderNode -> {
                if (!(structure instanceof MojangsonList array)) {
                    throw new MojangsonPathUnableToAccessException("パスに対応する値へのアクセスに失敗しました: ノード " + node + " にアクセスするには " + structure + " がリストである必要があります");
                }
                return arrayIndexFinderNode.access(array, function::use);
            }
            default -> throw new IllegalArgumentException();
        }
    }

    private <U> @Nullable U onTermination(MojangsonCompound compound, MojangsonPathReferer<MojangsonStructure, Object, @Nullable U> function, boolean isForcedAccess) throws MojangsonPathUnableToAccessException {
        MojangsonPathNode<?, ?> node = root;
        MojangsonStructure currentStruct = compound;

        while (node.child != null) {
            MojangsonStructure nextStruct = checkedAccess(node, currentStruct, (a, b) -> {
                final MojangsonValue<?> value = switch (a) {
                    case MojangsonCompound obj -> obj.get((String) b, obj.getTypeOf((String) b));
                    case MojangsonList arr -> arr.get((Integer) b, arr.getTypeAt((Integer) b));
                    default -> throw new IllegalStateException("NEVER HAPPENS");
                };
                if (value instanceof MojangsonStructure structure) {
                    return structure;
                }
                else {
                    throw new MojangsonPathUnableToAccessException("パスに対応する値へのアクセスに失敗しました: アクセス過程で取得された値 " + value + " は構造体ではありませんが、パスはこの先にも続いています");
                }
            });

            if (nextStruct == null) {
                if (node instanceof MojangsonPathNode.ObjectKeyNode objectKeyNode && isForcedAccess) {
                    nextStruct = new MojangsonCompound();
                    ((MojangsonCompound) currentStruct).set(objectKeyNode.parameter, nextStruct);
                }
                else {
                    throw new MojangsonPathUnableToAccessException("パスに対応する値へのアクセスに失敗しました: 条件 " + node.parameter + " を満たすキーは存在しません");
                }
            }

            currentStruct = nextStruct;
            node = node.child;
        }

        return checkedAccess(node, currentStruct, function);
    }

    public <T> @Nullable T access(MojangsonCompound MojangsonCompound, Function<MojangsonPathReference<?, ?>, @Nullable T> function, boolean isForcedAccess) throws MojangsonPathUnableToAccessException {
        return onTermination(MojangsonCompound, (lastStructure, nodeParameter) -> {
            final MojangsonPathReference<?, ?> reference = switch (lastStructure) {
                case MojangsonCompound object -> new MojangsonPathReference.MojangsonCompoundPathReference(object, (String) nodeParameter);
                case MojangsonList array -> new MojangsonPathReference.MojangsonListPathReference(array, (Integer) nodeParameter);
                default -> throw new IllegalArgumentException("NEVER HAPPENS");
            };

            return function.apply(reference);
        }, isForcedAccess);
    }

    public int length() {
        MojangsonPathNode<?, ?> node = root;

        int i = 0;
        while (node != null) {
            i++;
            node = node.child;
        }

        return i;
    }

    public MojangsonPath slice(int begin, int end) {
        if (begin < 0 || end > length() || begin > end) {
            throw new IllegalArgumentException("インデックスが範囲外です");
        }

        MojangsonPathNode<?, ?> beginNode = root;
        for (int i = 0; i < begin; i++) {
            if (beginNode == null) {
                throw new IllegalStateException("NEVER HAPPENS");
            }

            beginNode = beginNode.child;
        }

        MojangsonPathNode<?, ?> node = beginNode;
        for (int i = begin; i < end; i++) {
            if (node == null) {
                throw new IllegalStateException("NEVER HAPPENS");
            }

            node = node.child;
        }

        if (node == null) {
            throw new IllegalStateException("NEVER HAPPENS");
        }

        node.child = null;

        return new MojangsonPath(beginNode);
    }

    public MojangsonPath parent() {
        return slice(0, length() - 2);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MojangsonPath { ");
        MojangsonPathNode<?, ?> node = root;

        while (node != null) {
            sb.append(node);
            node = node.child;

            if (node != null) {
                sb.append(".");
            }
        }

        return sb.append(" }").toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        else if (obj == this) return true;
        else if (obj.getClass() != getClass()) return false;
        else return toString().equals(obj.toString());
    }

    public static MojangsonPath of(String path) throws MojangsonParseException {
        return new MojangsonPathParser().parse(path);
    }

    public static abstract class MojangsonPathReference<S extends MojangsonStructure, T> {
        protected final S structure;

        protected final T parameter;

        protected MojangsonPathReference(S structure, T parameter) {
            this.structure = structure;
            this.parameter = parameter;
        }

        public abstract boolean has();

        public abstract MojangsonValueType<?> getType();

        public abstract <U extends MojangsonValue<?>> U get(MojangsonValueType<U> type);

        public abstract void set(Object value);

        public abstract boolean delete();

        private static final class MojangsonCompoundPathReference extends MojangsonPathReference<MojangsonCompound, String> {
            private MojangsonCompoundPathReference(MojangsonCompound structure, String parameter) {
                super(structure, parameter);
            }

            @Override
            public boolean has() {
                return structure.has(parameter);
            }

            @Override
            public MojangsonValueType<?> getType() {
                return structure.getTypeOf(parameter);
            }

            @Override
            public <U extends MojangsonValue<?>> U get(MojangsonValueType<U> type) {
                return structure.get(parameter, type);
            }

            @Override
            public void set(Object value) {
                structure.set(parameter, value);
            }

            @Override
            public boolean delete() {
                return structure.delete(parameter);
            }
        }

        private static final class MojangsonListPathReference extends MojangsonPathReference<MojangsonList, Integer> {
            private MojangsonListPathReference(MojangsonList structure, Integer parameter) {
                super(structure, parameter);
            }

            @Override
            public boolean has() {
                return structure.has(parameter);
            }

            @Override
            public MojangsonValueType<?> getType() {
                return structure.getTypeAt(parameter);
            }

            @Override
            public <U extends MojangsonValue<?>> U get(MojangsonValueType<U> type) {
                return structure.get(parameter, type);
            }

            @Override
            public void set(Object value) {
                structure.set(parameter, value);
            }

            @Override
            public boolean delete() {
                return structure.delete(parameter);
            }
        }
    }

}

package com.hugovs.jps.structure.semanthic;

public class Value {

    private Type type;
    private Object value = null;

    public Value() {}

    public Value(Type type, Object value) {this.type=type; this.value=value;}

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "<type=" + type + ", value=" + value + ">";
    }
}

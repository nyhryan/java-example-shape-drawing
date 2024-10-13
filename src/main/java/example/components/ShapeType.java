package example.components;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum ShapeType {
    NONE("선택"),
    CURVE("브러시"),
    RECTANGLE("사각형");

    private static final Map<String, ShapeType> map = new HashMap<>();

    static {
        for (ShapeType shape : ShapeType.values()) {
            map.put(shape.getName(), shape);
        }
    }

    private final String name;

    ShapeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ShapeType getShapeTypeByName(String name) {
        return Arrays.stream(ShapeType.values())
                .filter(shape -> shape.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid shape name: " + name));
    }
}

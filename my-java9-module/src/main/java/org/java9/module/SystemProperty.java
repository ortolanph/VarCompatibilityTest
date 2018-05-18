package org.java9.module;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SystemProperty {

    JAVA_HOME("java.home", PropertyCategory.JAVA, "Installation directory for Java Runtime Environment (JRE)"),
    JAVA_VENDOR("java.vendor", PropertyCategory.JAVA, "JRE vendor name"),
    JAVA_VENDOR_URL("java.vendor.url", PropertyCategory.JAVA, "JRE vendor URL"),
    JAVA_VERSION("java.version", PropertyCategory.JAVA, "JRE version number"),
    JAVA_CLASS_PATH("java.class.path", PropertyCategory.JAVA,
        "Path used to find directories and JAR archives containing class files. Elements of the class path are separated by a platform-specific character specified in the path.separator property."),
    JAVA_CLASS_VERSION("java.class.version", PropertyCategory.JAVA, "Java class format version number"),

    JAVA_VM_SPECIFICATION_VENDOR("java.vm.specification.vendor", PropertyCategory.VM,
        "Java Virtual Machine specification vendor"),
    JAVA_VM_SPECIFICATION_NAME("java.vm.specification.name", PropertyCategory.VM,
        "Java Virtual Machine specification name"),
    JAVA_VM_VERSION("java.vm.version", PropertyCategory.VM, "Java Virtual Machine implementation version"),
    JAVA_VM_VENDOR("java.vm.vendor", PropertyCategory.VM, "Java Virtual Machine implementation vendor"),
    JAVA_VM_NAME("java.vm.name", PropertyCategory.VM, "Java Virtual Machine implementation name"),

    JAVA_SPECIFICATION_VERSION("java.specification.version", PropertyCategory.SPECIFICATION,
        "Java Runtime Environment specification version"),
    JAVA_SPECIFICATION_VENDOR("java.specification.vendor", PropertyCategory.SPECIFICATION,
        "Java Runtime Environment specification vendor"),
    JAVA_SPECIFICATION_NAME("java.specification.name", PropertyCategory.SPECIFICATION,
        "Java Runtime Environment specification name"),

    JAVA_LIBRARY_PATH("java.library.path", PropertyCategory.MISC, "List of paths to search when loading libraries"),
    JAVA_IO_TMPDIR("java.io.tmpdir", PropertyCategory.MISC, "Default temp file path"),
    JAVA_COMPILER("java.compiler", PropertyCategory.MISC, "Name of JIT compiler to use"),
    JAVA_EXT_DIRS("java.ext.dirs", PropertyCategory.MISC, "Path of extension directory or directories"),

    OS_ARCH("os.arch", PropertyCategory.OS, "Operating system architecture"),
    OS_NAME("os.name", PropertyCategory.OS, "Operating system name"),
    OS_VERSION("os.version", PropertyCategory.OS, "Operating system version"),

    USER_DIR("user.dir", PropertyCategory.USER, "User working directory"),
    USER_HOME("user.home", PropertyCategory.USER, "User home directory"),
    USER_NAME("user.name", PropertyCategory.USER, "User account name"),

    PATH_SEPARATOR("path.separator", PropertyCategory.SEPARATOR, "Path separator character used in java.class.path"),
    FILE_SEPARATOR("file.separator", PropertyCategory.SEPARATOR,
        "Character that separates components of a file path. This is \"/\" on UNIX and \"\\\" on Windows."),
    LINE_SEPARATOR("line.separator", PropertyCategory.SEPARATOR,
        "Sequence used by operating system to separate lines in text files");

    private String property;

    private PropertyCategory category;

    private String description;

    SystemProperty(String property, PropertyCategory category, String description) {
        this.property = property;
        this.category = category;
        this.description = description;
    }

    public static void printPropertyReport() {
        Arrays
            .stream(PropertyCategory.values())
            .forEach(c -> {
                System.out.printf("\n[%s]\n", c.name());
                byCategory(c)
                    .stream()
                    .forEach(p -> System.out.printf("%s\t%s\n",
                        p.getProperty(),
                        p.getPropertyValue()));
            });
    }

    public static List<SystemProperty> byCategory(PropertyCategory category) {
        return
            Arrays
                .stream(values())
                .filter(p -> p.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public String getProperty() {
        return property;
    }

    public PropertyCategory getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getPropertyValue() {
        return System.getProperty(property);
    }
}

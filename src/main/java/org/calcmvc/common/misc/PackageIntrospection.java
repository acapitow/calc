package org.calcmvc.common.misc;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton to handle all methods using package introspection.
 * This class is mainly used to explore packages and create class instances dynamically.
 *
 * @author x. skapin
 */
public class PackageIntrospection {
    /** Logging utility */
    private static final Logger LOGGER = Logger.getLogger(PackageIntrospection.class.getName());

    /** Singleton instance */
    private static PackageIntrospection instance;

    //// Public ////

    /**
     * Searches for all classes inside a given package
     * @param packageName name of the package to explore. It should contain at least one class file.
     * @return a collection containing all the classes found inside this package
     */
    public List<Class<?>> getClassesInPackage(String packageName) {

        List<Class<?>> classes = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        // To explore the file path, the delimiter between package name's elements is replaced by
        // the delimiter depending on the operating system.
        String path = packageName.replace(".", File.separator);
        try {
            Enumeration<URL> resources = classLoader.getResources(path);
            // Fetch all data found in [path]
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                classes.addAll(findClassesInResource(packageName, resource));
            }
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.severe("[#getClassesInPackage] An error occurred: " + e.getMessage());
            LOGGER.log(Level.FINE, "Detailed error information", e);
        }

        return classes;
    }

    /** @return the single instance of this class */
    public static PackageIntrospection getInstance() {
        if (instance == null)
            instance = new PackageIntrospection();
        return instance;
    }


    //// Private ////

    /** Constructor */
    private PackageIntrospection() { }

    /**
     * Filters data stored in resource to select only class files
     * @param packageName name of the package currently explored (should match an actual directory containing some classes)
     * @param resource data storage. It contains the contents of a given path, which may be classes or not
     * @return a collection of class files only
     * @throws ClassNotFoundException exception thrown if no class has been found
     */
    private List<Class<?>> findClassesInResource(String packageName, URL resource) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        String classExtension = ".class";

        // Process "space" characters
        String filePath = resource.getPath().replaceAll("%20", " ");

        // Assuming the resource is a directory, get all classes within it
        String[] files = new java.io.File(filePath).list();
        if (files != null) {
            for (String file : files) {
                if (file.endsWith(classExtension)) {
                    String className = packageName + "." + file.substring(0, file.length() - classExtension.length());
                    classes.add(Class.forName(className));
                }
            }
        }
        return classes;
    }
}

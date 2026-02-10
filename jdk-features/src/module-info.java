module jdk.features {
    requires java.logging;
    requires java.net.http;
    requires jdk.jfr;
    requires jdk.incubator.vector;
    requires jdk.compiler;
    exports common;
}
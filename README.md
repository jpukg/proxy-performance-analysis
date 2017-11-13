JDK Dynamic proxy performance analysis
======================================

To extract JDK generated classes run the following command:
```
./gradlew run
```

Interesting classes after build are located here:
```
build/decompiled/com/sun/proxy/\$Proxy0.java
build/decompiled/com/sun/proxy/\$Proxy1.java
build/decompiled/com/sun/proxy/\$Proxy2.java

build/decompiled/sun/reflect/GeneratedMethodAccessor1.java
build/decompiled/sun/reflect/GeneratedMethodAccessor2.java
```

The classes can also be found on the 'demo' branch:

[$Proxy0](../demo/com/sun/proxy/\$Proxy0.java)

[$Proxy1](../demo/com/sun/proxy/\$Proxy1.java)

[$Proxy2](../demo/com/sun/proxy/\$Proxy2.java)

[GeneratedMethodAccessor1](../demo/sun/reflect/GeneratedMethodAccessor1.java)

[GeneratedMethodAccessor2](../demo/sun/reflect/GeneratedMethodAccessor2.java)


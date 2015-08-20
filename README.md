appengine-skeleton
=============================

This is a generated application from the appengine-skeleton archetype.


# Overview

This project was created from the appengine-skeleton, sourced from the following documentation:  

- [Google Cloud Platform - Maven App Engine Archetypes](https://cloud.google.com/appengine/docs/java/tools/maven#maven_app_engine_archetypes)

This requires that you install maven 3.1+.  I used Maven 3.3.3, the latest version at the time of this writing.  Note that maven 3.3.3 requires JDK 1.7, so you'll need to set JAVA_HOME to point to your JDK 1.7. Get your JDK path from Eclipse.

I created the skeleton using the following command:

```
mvn archetype:generate -Dappengine-version=1.9.25 -Dapplication-id=your-app-id -Dfilter=com.google.appengine.archetypes:
```

And then answered the questions as best I knew.

To run the devserver, and also install missing dependencies, run the following command:

```
mvn appengine:devserver
```



# Troubleshooting

If you see this it means maven is looking at the wrong JDK. You need to set JAVA_HOME to the JDK 1.7.

```
Jamess-MacBook-Pro-3:bin jem$ ./mvn --version
Exception in thread "main" java.lang.UnsupportedClassVersionError: org/apache/maven/cli/MavenCli : Unsupported major.minor version 51.0
	at java.lang.ClassLoader.defineClass1(Native Method)
	at java.lang.ClassLoader.defineClassCond(ClassLoader.java:637)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:621)
	at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:141)
	at java.net.URLClassLoader.defineClass(URLClassLoader.java:283)
	at java.net.URLClassLoader.access$000(URLClassLoader.java:58)
	at java.net.URLClassLoader$1.run(URLClassLoader.java:197)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.net.URLClassLoader.findClass(URLClassLoader.java:190)
	at org.codehaus.plexus.classworlds.realm.ClassRealm.loadClassFromSelf(ClassRealm.java:401)
	at org.codehaus.plexus.classworlds.strategy.SelfFirstStrategy.loadClass(SelfFirstStrategy.java:42)
	at org.codehaus.plexus.classworlds.realm.ClassRealm.unsynchronizedLoadClass(ClassRealm.java:271)
	at org.codehaus.plexus.classworlds.realm.ClassRealm.loadClass(ClassRealm.java:254)
	at org.codehaus.plexus.classworlds.realm.ClassRealm.loadClass(ClassRealm.java:239)
	at org.codehaus.plexus.classworlds.launcher.Launcher.getMainClass(Launcher.java:144)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:266)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:229)
	at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:415)
	at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:356)
```

This means you need to add the junit dependency to the dependencies element of the pom.xml
```
package junit.framework does not exist
```

add this:
```
 		<dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
        </dependency>
        <dependency>
          <groupId>com.googlecode.objectify</groupId>
          <artifactId>objectify</artifactId>
          <version>5.1.6</version>
        </dependency>
```

We also include objectify, since this demo will require it.


#Jenkins 

Part of this demo involves setting up a continuous integration server on Mac OS locally.  A real setup would be on a Google Compute instance, but for the demo we work locally.

By default, Jenkins will run on localhost:8080, which just happens to conflict with App Engine's dev server running on port 8080. So we change the Jenkins port by changing the default at the command line:

```
sudo defaults write /Library/Preferences/org.jenkins-ci httpPort 9090
```

Note that stopping Jenkins is as follows: 

```
$ sudo launchctl unload /Library/LaunchDaemons/org.jenkins-ci.plist
```

And starting is done with this command:
```
$ sudo launchctl load /Library/LaunchDaemons/org.jenkins-ci.plist
```

Now you can go to http://localhost:9090 so there are no port conflicts with App Engine.

Note that the above commands run Jenkins as a daemon.


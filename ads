[33mcommit f1b17b1d87d63701f586c46859facb1a1bd790e8[m[33m ([m[1;36mHEAD -> [m[1;32mmaster[m[33m, [m[1;31morigin/master[m[33m)[m
Author: csr9497 <cesaraop.12@gmail.com>
Date:   Mon May 28 23:29:22 2018 -0500

    start

[1mdiff --git a/.gitignore b/.gitignore[m
[1mnew file mode 100644[m
[1mindex 0000000..5edb4ee[m
[1m--- /dev/null[m
[1m+++ b/.gitignore[m
[36m@@ -0,0 +1,10 @@[m
[32m+[m[32m*.iml[m
[32m+[m[32m.gradle[m
[32m+[m[32m/local.properties[m
[32m+[m[32m/.idea/libraries[m
[32m+[m[32m/.idea/modules.xml[m
[32m+[m[32m/.idea/workspace.xml[m
[32m+[m[32m.DS_Store[m
[32m+[m[32m/build[m
[32m+[m[32m/captures[m
[32m+[m[32m.externalNativeBuild[m
[1mdiff --git a/.idea/assetWizardSettings.xml b/.idea/assetWizardSettings.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..a8c1e54[m
[1m--- /dev/null[m
[1m+++ b/.idea/assetWizardSettings.xml[m
[36m@@ -0,0 +1,58 @@[m
[32m+[m[32m<?xml version="1.0" encoding="UTF-8"?>[m
[32m+[m[32m<project version="4">[m
[32m+[m[32m  <component name="WizardSettings">[m
[32m+[m[32m    <option name="children">[m
[32m+[m[32m      <map>[m
[32m+[m[32m        <entry key="imageWizard">[m
[32m+[m[32m          <value>[m
[32m+[m[32m            <PersistentState>[m
[32m+[m[32m              <option name="children">[m
[32m+[m[32m                <map>[m
[32m+[m[32m                  <entry key="imageAssetPanel">[m
[32m+[m[32m                    <value>[m
[32m+[m[32m                      <PersistentState>[m
[32m+[m[32m                        <option name="children">[m
[32m+[m[32m                          <map>[m
[32m+[m[32m                            <entry key="launcher">[m
[32m+[m[32m                              <value>[m
[32m+[m[32m                                <PersistentState>[m
[32m+[m[32m                                  <option name="children">[m
[32m+[m[32m                                    <map>[m
[32m+[m[32m                                      <entry key="foregroundImage">[m
[32m+[m[32m                                        <value>[m
[32m+[m[32m                                          <PersistentState>[m
[32m+[m[32m                                            <option name="values">[m
[32m+[m[32m                                              <map>[m
[32m+[m[32m                                                <entry key="scalingPercent" value="163" />[m
[32m+[m[32m                                                <entry key="trimmed" value="true" />[m
[32m+[m[32m                                              </map>[m
[32m+[m[32m                                            </option>[m
[32m+[m[32m                                          </PersistentState>[m
[32m+[m[32m                                        </value>[m
[32m+[m[32m                                      </entry>[m
[32m+[m[32m                                    </map>[m
[32m+[m[32m                                  </option>[m
[32m+[m[32m                                  <option name="values">[m
[32m+[m[32m                                    <map>[m
[32m+[m[32m                                      <entry key="foregroundImage" value="$USER_HOME$/Desktop/icon.png" />[m
[32m+[m[32m                                      <entry key="legacyIconShape" value="CIRCLE" />[m
[32m+[m[32m                                      <entry key="webIconShape" value="CIRCLE" />[m
[32m+[m[32m                                    </map>[m
[32m+[m[32m                                  </option>[m
[32m+[m[32m                                </PersistentState>[m
[32m+[m[32m                              </value>[m
[32m+[m[32m                            </entry>[m
[32m+[m[32m                          </map>[m
[32m+[m[32m                        </option>[m
[32m+[m[32m                      </PersistentState>[m
[32m+[m[32m                    </value>[m
[32m+[m[32m                  </entry>[m
[32m+[m[32m                </map>[m
[32m+[m[32m              </option>[m
[32m+[m[32m            </PersistentState>[m
[32m+[m[32m          </value>[m
[32m+[m[32m        </entry>[m
[32m+[m[32m      </map>[m
[32m+[m[32m    </option>[m
[32m+[m[32m  </component>[m
[32m+[m[32m</project>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/caches/build_file_checksums.ser b/.idea/caches/build_file_checksums.ser[m
[1mnew file mode 100644[m
[1mindex 0000000..5fae431[m
Binary files /dev/null and b/.idea/caches/build_file_checksums.ser differ
[1mdiff --git a/.idea/codeStyles/Project.xml b/.idea/codeStyles/Project.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..30aa626[m
[1m--- /dev/null[m
[1m+++ b/.idea/codeStyles/Project.xml[m
[36m@@ -0,0 +1,29 @@[m
[32m+[m[32m<component name="ProjectCodeStyleConfiguration">[m
[32m+[m[32m  <code_scheme name="Project" version="173">[m
[32m+[m[32m    <Objective-C-extensions>[m
[32m+[m[32m      <file>[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="Import" />[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="Macro" />[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="Typedef" />[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="Enum" />[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="Constant" />[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="Global" />[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="Struct" />[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="FunctionPredecl" />[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="Function" />[m
[32m+[m[32m      </file>[m
[32m+[m[32m      <class>[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="Property" />[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="Synthesize" />[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="InitMethod" />[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="StaticMethod" />[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="InstanceMethod" />[m
[32m+[m[32m        <option name="com.jetbrains.cidr.lang.util.OCDeclarationKind" value="DeallocMethod" />[m
[32m+[m[32m      </class>[m
[32m+[m[32m      <extensions>[m
[32m+[m[32m        <pair source="cpp" header="h" fileNamingConvention="NONE" />[m
[32m+[m[32m        <pair source="c" header="h" fileNamingConvention="NONE" />[m
[32m+[m[32m      </extensions>[m
[32m+[m[32m    </Objective-C-extensions>[m
[32m+[m[32m  </code_scheme>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/gradle.xml b/.idea/gradle.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..7ac24c7[m
[1m--- /dev/null[m
[1m+++ b/.idea/gradle.xml[m
[36m@@ -0,0 +1,18 @@[m
[32m+[m[32m<?xml version="1.0" encoding="UTF-8"?>[m
[32m+[m[32m<project version="4">[m
[32m+[m[32m  <component name="GradleSettings">[m
[32m+[m[32m    <option name="linkedExternalProjectsSettings">[m
[32m+[m[32m      <GradleProjectSettings>[m
[32m+[m[32m        <option name="distributionType" value="DEFAULT_WRAPPED" />[m
[32m+[m[32m        <option name="externalProjectPath" value="$PROJECT_DIR$" />[m
[32m+[m[32m        <option name="modules">[m
[32m+[m[32m          <set>[m
[32m+[m[32m            <option value="$PROJECT_DIR$" />[m
[32m+[m[32m            <option value="$PROJECT_DIR$/app" />[m
[32m+[m[32m          </set>[m
[32m+[m[32m        </option>[m
[32m+[m[32m        <option name="resolveModulePerSourceSet" value="false" />[m
[32m+[m[32m      </GradleProjectSettings>[m
[32m+[m[32m    </option>[m
[32m+[m[32m  </component>[m
[32m+[m[32m</project>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/misc.xml b/.idea/misc.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..99202cc[m
[1m--- /dev/null[m
[1m+++ b/.idea/misc.xml[m
[36m@@ -0,0 +1,34 @@[m
[32m+[m[32m<?xml version="1.0" encoding="UTF-8"?>[m
[32m+[m[32m<project version="4">[m
[32m+[m[32m  <component name="NullableNotNullManager">[m
[32m+[m[32m    <option name="myDefaultNullable" value="android.support.annotation.Nullable" />[m
[32m+[m[32m    <option name="myDefaultNotNull" value="android.support.annotation.NonNull" />[m
[32m+[m[32m    <option name="myNullables">[m
[32m+[m[32m      <value>[m
[32m+[m[32m        <list size="5">[m
[32m+[m[32m          <item index="0" class="java.lang.String" itemvalue="org.jetbrains.annotations.Nullable" />[m
[32m+[m[32m          <item index="1" class="java.lang.String" itemvalue="javax.annotation.Nullable" />[m
[32m+[m[32m          <item index="2" class="java.lang.String" itemvalue="javax.annotation.CheckForNull" />[m
[32m+[m[32m          <item index="3" class="java.lang.String" itemvalue="edu.umd.cs.findbugs.annotations.Nullable" />[m
[32m+[m[32m          <item index="4" class="java.lang.String" itemvalue="android.support.annotation.Nullable" />[m
[32m+[m[32m        </list>[m
[32m+[m[32m      </value>[m
[32m+[m[32m    </option>[m
[32m+[m[32m    <option name="myNotNulls">[m
[32m+[m[32m      <value>[m
[32m+[m[32m        <list size="4">[m
[32m+[m[32m          <item index="0" class="java.lang.String" itemvalue="org.jetbrains.annotations.NotNull" />[m
[32m+[m[32m          <item index="1" class="java.lang.String" itemvalue="javax.annotation.Nonnull" />[m
[32m+[m[32m          <item index="2" class="java.lang.String" itemvalue="edu.umd.cs.findbugs.annotations.NonNull" />[m
[32m+[m[32m          <item index="3" class="java.lang.String" itemvalue="android.support.annotation.NonNull" />[m
[32m+[m[32m        </list>[m
[32m+[m[32m      </value>[m
[32m+[m[32m    </option>[m
[32m+[m[32m  </component>[m
[32m+[m[32m  <component name="ProjectRootManager" version="2" languageLevel="JDK_1_7" project-jdk-name="1.8" project-jdk-type="JavaSDK">[m
[32m+[m[32m    <output url="file://$PROJECT_DIR$/build/classes" />[m
[32m+[m[32m  </component>[m
[32m+[m[32m  <component name="ProjectType">[m
[32m+[m[32m    <option name="id" value="Android" />[m
[32m+[m[32m  </component>[m
[32m+[m[32m</project>[m
\ No newline at end of file[m
[1mdiff --git a/.idea/runConfigurations.xml b/.idea/runConfigurations.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..7f68460[m
[1m--- /dev/null[m
[1m+++ b/.idea/runConfigurations.xml[m
[36m@@ -0,0 +1,12 @@[m
[32m+[m[32m<?xml version="1.0" encoding="UTF-8"?>[m
[32m+[m[32m<project version="4">[m
[32m+[m[32m  <component name="RunConfigurationProducerService">[m
[32m+[m[32m    <option name="ignoredProducers">[m
[32m+[m[32m      <set>[m
[32m+[m[32m        <option value="org.jetbrains.plugins.gradle.execution.test.runner.AllInPackageGradleConfigurationProducer" />[m
[32m+[m[32m        <option value="org.jetbrains.plugins.gradle.execution.test.runner.TestClassGradleConfigurationProducer" />[m
[32m+[m[32m        <option value="org.jetbrains.plugins.gradle.execution.test.runner.TestMethodGradleConfigurationProducer" />[m
[32m+[m[32m      </set>[m
[32m+[m[32m    </option>[m
[32m+[m[32m  </component>[m
[32m+[m[32m</project>[m
\ No newline at end of file[m
[1mdiff --git a/app/.gitignore b/app/.gitignore[m
[1mnew file mode 100644[m
[1mindex 0000000..796b96d[m
[1m--- /dev/null[m
[1m+++ b/app/.gitignore[m
[36m@@ -0,0 +1 @@[m
[32m+[m[32m/build[m
[1mdiff --git a/app/build.gradle b/app/build.gradle[m
[1mnew file mode 100644[m
[1mindex 0000000..5b3233c[m
[1m--- /dev/null[m
[1m+++ b/app/build.gradle[m
[36m@@ -0,0 +1,28 @@[m
[32m+[m[32mapply plugin: 'com.android.application'[m
[32m+[m
[32m+[m[32mandroid {[m
[32m+[m[32m    compileSdkVersion 27[m
[32m+[m[32m    defaultConfig {[m
[32m+[m[32m        applicationId "app.desarrollo.proyecto.plasiette"[m
[32m+[m[32m        minSdkVersion 19[m
[32m+[m[32m        targetSdkVersion 27[m
[32m+[m[32m        versionCode 1[m
[32m+[m[32m        versionName "1.0"[m
[32m+[m[32m        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"[m
[32m+[m[32m    }[m
[32m+[m[32m    buildTypes {[m
[32m+[m[32m        release {[m
[32m+[m[32m            minifyEnabled false[m
[32m+[m[32m            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'[m
[32m+[m[32m        }[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m
[32m+[m[32mdependencies {[m
[32m+[m[32m    implementation fileTree(dir: 'libs', include: ['*.jar'])[m
[32m+[m[32m    implementation 'com.android.support:appcompat-v7:27.1.1'[m
[32m+[m[32m    implementation 'com.android.support.constraint:constraint-layout:1.1.0'[m
[32m+[m[32m    testImplementation 'junit:junit:4.12'[m
[32m+[m[32m    androidTestImplementation 'com.android.support.test:runner:1.0.2'[m
[32m+[m[32m    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'[m
[32m+[m[32m}[m
[1mdiff --git a/app/proguard-rules.pro b/app/proguard-rules.pro[m
[1mnew file mode 100644[m
[1mindex 0000000..f1b4245[m
[1m--- /dev/null[m
[1m+++ b/app/proguard-rules.pro[m
[36m@@ -0,0 +1,21 @@[m
[32m+[m[32m# Add project specific ProGuard rules here.[m
[32m+[m[32m# You can control the set of applied configuration files using the[m
[32m+[m[32m# proguardFiles setting in build.gradle.[m
[32m+[m[32m#[m
[32m+[m[32m# For more details, see[m
[32m+[m[32m#   http://developer.android.com/guide/developing/tools/proguard.html[m
[32m+[m
[32m+[m[32m# If your project uses WebView with JS, uncomment the following[m
[32m+[m[32m# and specify the fully qualified class name to the JavaScript interface[m
[32m+[m[32m# class:[m
[32m+[m[32m#-keepclassmembers class fqcn.of.javascript.interface.for.webview {[m
[32m+[m[32m#   public *;[m
[32m+[m[32m#}[m
[32m+[m
[32m+[m[32m# Uncomment this to preserve the line number information for[m
[32m+[m[32m# debugging stack traces.[m
[32m+[m[32m#-keepattributes SourceFile,LineNumberTable[m
[32m+[m
[32m+[m[32m# If you keep the line number information, uncomment this to[m
[32m+[m[32m# hide the original source file name.[m
[32m+[m[32m#-renamesourcefileattribute SourceFile[m
[1mdiff --git a/app/src/androidTest/java/app/desarrollo/proyecto/plasiette/ExampleInstrumentedTest.java b/app/src/androidTest/java/app/desarrollo/proyecto/plasiette/ExampleInstrumentedTest.java[m
[1mnew file mode 100644[m
[1mindex 0000000..9ed750c[m
[1m--- /dev/null[m
[1m+++ b/app/src/androidTest/java/app/desarrollo/proyecto/plasiette/ExampleInstrumentedTest.java[m
[36m@@ -0,0 +1,26 @@[m
[32m+[m[32mpackage app.desarrollo.proyecto.plasiette;[m
[32m+[m
[32m+[m[32mimport android.content.Context;[m
[32m+[m[32mimport android.support.test.InstrumentationRegistry;[m
[32m+[m[32mimport android.support.test.runner.AndroidJUnit4;[m
[32m+[m
[32m+[m[32mimport org.junit.Test;[m
[32m+[m[32mimport org.junit.runner.RunWith;[m
[32m+[m
[32m+[m[32mimport static org.junit.Assert.*;[m
[32m+[m
[32m+[m[32m/**[m
[32m+[m[32m * Instrumented test, which will execute on an Android device.[m
[32m+[m[32m *[m
[32m+[m[32m * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>[m
[32m+[m[32m */[m
[32m+[m[32m@RunWith(AndroidJUnit4.class)[m
[32m+[m[32mpublic class ExampleInstrumentedTest {[m
[32m+[m[32m    @Test[m
[32m+[m[32m    public void useAppContext() {[m
[32m+[m[32m        // Context of the app under test.[m
[32m+[m[32m        Context appContext = InstrumentationRegistry.getTargetContext();[m
[32m+[m
[32m+[m[32m        assertEquals("app.d
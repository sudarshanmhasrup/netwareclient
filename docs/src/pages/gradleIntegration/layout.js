import React from 'react';
import SyntaxHighlighter from 'react-syntax-highlighter';
import themeLight from '../../json/themeLight';

const theme = themeLight;
const backgroundColor = "#070707;";

const Step1 = () => (
    <div className="step-content-container">
        <h3 className="step-highlighter">Step 1: Add JitPack Repository</h3>
        <p className="step-description-paragraph">
            Add the following line in your project's <code>build.gradle.kts</code> or <code>build.gradle</code> file depending on which build type you are using. Add it inside the <code>repositories</code> block and then click on sync.
        </p>
        <div className="code-container">
            <pre className="code-container-pre">
                <SyntaxHighlighter
                    language="kotlin"
                    style={theme}
                    customStyle={{ padding: '20px', backgroundColor: backgroundColor, lineHeight: "34px", fontSize: "14px" }}
                >
                    {`// For build.gradle.kts:\nrepositories {\n    mavenCentral()\n    maven { url = uri("https://jitpack.io") }\n}\n\n// For build.gradle:\nrepositories {\n    mavenCentral()\n    maven { url 'https://jitpack.io' }\n}`}
                </SyntaxHighlighter>
            </pre>
        </div>
        <p className="step-description-paragraph">
            Make sure that the JitPack repository is included in your repositories list before adding the dependency.
        </p>
    </div>
);

const Step2 = () => (
    <div className="step-content-container" style={{ marginTop: "10px" }}>
        <h3 className="step-highlighter">Step 2: Add Library Dependency</h3>
        <p className="step-description-paragraph">
            Add the following line in your project's <code>build.gradle.kts</code> or <code>build.gradle</code> file. Add it inside the <code>dependencies</code> block and then click on sync.
        </p>
        <div className="code-container">
            <pre className="code-container-pre">
                <SyntaxHighlighter
                    language="kotlin"
                    style={theme}
                    customStyle={{ padding: '20px', backgroundColor: backgroundColor, lineHeight: "34px", fontSize: "14px" }}
                >
                    {`// For build.gradle.kts:\ndependencies {\n    implementation("com.github.sudarshanmhasrup:netwareclient:v0.0.3-alpha")\n}\n\n// For build.gradle:\ndependencies {\n    implementation "com.github.sudarshanmhasrup:netwareclient:v0.0.3-alpha"\n}`}
                </SyntaxHighlighter>
            </pre>
        </div>
        <p className="step-description-paragraph">
            Ensure you add this inside the <code>dependencies</code> block to include the Netware Client library in your project.
        </p>
    </div>
);

const GradleIntegration = () => (
    <>
        <div className="topic-container">
            <h2 className="topic-highlighter">
                Adding Netware Client to Your Project
            </h2>
            <p className="topic-overview">
                You can use the Netware Client library in Java or Kotlin projects that use Gradle as their build system. Follow these steps to add the library to your project.
            </p>
        </div>
        <Step1 />
        <Step2 />
    </>
);

export default GradleIntegration;

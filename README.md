# Sample
Templated Architected

From the Android Studio Basic Activity Template, with Hilt, and a RecyclerView added in.

Has the basics for Navgraph, MVM, repository and Hilt injection.


## Add Hilt

#### Add to top level build file
```
    buildscript {
        ext.kotlin_version = "1.4.10"
        ext.hilt_version = '2.28-alpha'
        repositories {
            google()
            jcenter()
        }
        dependencies {
            classpath 'com.android.tools.build:gradle:4.1.0'
            classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
            classpath "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"

            // NOTE: Do not place your application dependencies here; they belong
            // in the individual module build.gradle files
        }
    }
```
#### Add to app build file
```
    apply plugin: 'com.android.application'
    apply plugin: 'kotlin-android'
    apply plugin: 'kotlin-android-extensions'
    apply plugin: 'kotlin-kapt'
    apply plugin: 'dagger.hilt.android.plugin'
```

```
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
```
```
dependencies {


    // Hilt dependencies
    kapt "com.google.dagger:hilt-android-compiler:$hilt_version"
    kapt 'androidx.hilt:hilt-compiler:1.0.0-alpha01'

    //Hilt extensions - for the ViewModelInject
    implementation "com.google.dagger:hilt-android:$hilt_version"
    implementation 'androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01'

    //also useful, for by viewModels
    implementation 'androidx.fragment:fragment-ktx:1.2.5'
    //also useful, for liveData builder
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
}
```

#### Create an annotated Application class
```
@HiltAndroidApp
class Hilt1Application: Application()
```

#### Annotate activities and fragments
```
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
```
```
@AndroidEntryPoint
class MainFragment : Fragment() {
```

#### Annotate ViewModel constructor
```
class MainViewModel @ViewModelInject constructor(private val repository: Repository): ViewModel() {
```

#### Create and annotate respositories as appropriate, using predefine qualifiers if required. eg:
```
class Repository @Inject constructor(@ApplicationContext val context: Context) {

```

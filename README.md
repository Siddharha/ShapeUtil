# ShapeUtil
ShapeUtill is a library for Shape Creation and image shape manipulation

## Installation.
1. Add Below to root project gradle.build

        allprojects {
            repositories {
              ...
              maven { url 'https://jitpack.io' }
            }
          }
          
2. Add Below to app gradle.build

        	dependencies {
	        implementation 'com.github.Siddharha:ShapeUtil:0.2.0'
	        }

## Use Guide.
1. For Circle Drawing:

         <in.creativelizard.shapeutil.CircleView
                    android:layout_width="100dp"
                    android:layout_height="100dp"
                    app:feel_back_color="#00bcd4"
                    app:feel_color="true"
                    app:src="@color/colorPrimary"
                    app:stroke_size="5"
                    android:layout_alignParentLeft="true" />  

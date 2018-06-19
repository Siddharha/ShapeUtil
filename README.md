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
	        implementation 'com.github.Siddharha:ShapeUtil:0.2.2'
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

For Image view in circle use:
			
	app:draw_img_back="@drawable/image"
2. For Any Shape use:
		
		<in.creativelizard.shapeutil.ShapeImageView
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:layout_marginStart="131dp"
        android:layout_marginTop="144dp"
        app:sm_draw_img_back="@drawable/image"
        app:sm_draw_img_mask="@drawable/mask"
        app:sm_feel_back_color="#00bcd4"
        app:sm_feel_color="true" />

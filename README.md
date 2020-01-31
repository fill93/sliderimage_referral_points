# Slider Image Referral Points
ViewPager of images with position reference points

# Installation

    allprojects {
      repositories {
        google()
        jcenter()
        ...
        maven { url 'https://jitpack.io' }
      }
    }

Build.gradle

    dependencies {
      implementation 'com.github.fill93:sliderimage_referral_points:1.0.3'
    }
    
[![](https://jitpack.io/v/fill93/sliderimage_referral_points.svg)](https://jitpack.io/#fill93/sliderimage_referral_points)
    
# Usage

Add the XML tag as shown in the image

![](CapturarXmlImageSlider.PNG)


Instantiate your list of **SliderItem** objects and add your Items

![](InstanciaLista.PNG)


Use **setPages** passing your list

![](SetPages.PNG)
   

Use **handleAnimate** by passing the time in milliseconds to animate your slide

![](handleAnimate.PNG)
    

To capture user input on your slide, implement the **CallOnClickSlider** interface and its method **(onClickSlider)**

![](callSlider.PNG)
    
# Result

![](PrintMyApp.jpeg)



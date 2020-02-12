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
      implementation 'com.github.fill93:sliderimage_referral_points:1.0.4'
    }
    
[![](https://jitpack.io/v/fill93/sliderimage_referral_points.svg)](https://jitpack.io/#fill93/sliderimage_referral_points)
    
# Usage

Add the XML tag as shown in the image

![](CapturarXmlImageSlider.PNG)


Instantiate your list of **SliderItem** objects and add your Items

![](InstanciaLista.PNG)


Use **setPages** passing your list

![](SetPages.PNG)
        
Pass as 2nd parameter **R.drawable.yourimage** to **setPages** function if you want to add an image in case of an error loading the image in the slider
   

Use **handleAnimate** by passing the time in milliseconds to animate your slide

![](handleAnimate.PNG)
    

To capture user input on your slide, implement the **CallOnClickSlider** interface and its method **(onClickSlider)**

![](callSlider.PNG)
    
# Result

[Veja o resultado aqui (Vídeo)](https://www.linkedin.com/posts/filipe-pimentel-97854111b_simples-por%C3%A9m-muito-%C3%BAtil-image-slider-activity-6633460640138698752-SUtf)





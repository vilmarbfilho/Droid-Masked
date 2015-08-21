Droid-Masked
=======

<img src="https://raw.githubusercontent.com/vilmarbfilho/Droid-Masked/master/droidMasked.png" alt="DroidMasked" />

Usage
-----
Droid-Masked provides two ways of define a mask, programmatically or by layout XML.


```java
// Define a mask programmatically
mEditTextMasked.addMask("###.###.###-##");

// Define a array of masks
String[] masks = {"###-###", "###.###-##", "##-##"};
mEditTextMasked.addMask(masks);

```

Layout XML:

```xml
<com.vlabs.droidmasked.views.EditTextMasked
        android:id="@+id/et_mask"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:layout_marginTop="15dp"
        android:background="@drawable/bg_square"
        android:padding="5dp"
        custom:mask="(##) ####-####|(##) #####-####|(##)###" />
```

License
--------

    Copyright 2015 Vilmar Bispo Filho

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

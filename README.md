This layer depends on:

    URI: git://git.yoctoproject.org/poky.git
    branch: gatesgarth 

    URI: git://git.openembedded.org/meta-openembedded
    branch: gatesgarth

    URI: git://git.yoctoproject.org/meta-security.git
    branch: gatesgarth

    URI: https://github.com/jumpnow/meta-jumpnow.git
    branch: gatesgarth

Latest commits:

    poky 708f3ca9ac
    meta-openembedded cef93b7b0
    meta-security 4583ab9 
    meta-jumpnow 3dd7b9a

meta-duovero layer maintainer: Scott Ellis <scott@jumpnowtek.com>

Note: wifi broke again somewhere between 4.19 and 5.0.
      The firmware is not loading (again). I currently have
      no incentive to fix as my Duovero projects only need
      ethernet.

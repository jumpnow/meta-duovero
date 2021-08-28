This layer depends on:

    URI: git://git.yoctoproject.org/poky.git
    branch: hardknott 

    URI: git://git.openembedded.org/meta-openembedded
    branch: hardknott

    URI: git://git.yoctoproject.org/meta-security.git
    branch: hardknott

Latest commits:

    poky b89bb2651d
    meta-openembedded d323115ec
    meta-security 5050d12

meta-duovero layer maintainer: Scott Ellis <scott@jumpnowtek.com>

Note: wifi broke again somewhere between 4.19 and 5.0.
      The firmware is not loading (again). I currently have
      no incentive to fix as my Duovero projects only need
      ethernet.

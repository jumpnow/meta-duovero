This layer depends on:

    URI: git://git.yoctoproject.org/poky.git
    branch: zeus

    URI: git://git.openembedded.org/meta-openembedded
    branch: zeus

    URI: git://git.yoctoproject.org/meta-security.git
    branch: zeus

    URI: https://github.com/jumpnow/meta-jumpnow.git
    branch: zeus

Latest commits:

    poky 73fe0e273b
    meta-openembedded e855ecc6d
    meta-security ecd8c30
    meta-jumpnow 6869932


meta-duovero layer maintainer: Scott Ellis <scott@jumpnowtek.com>


Note: wifi broke again somewhere between 4.19 and 5.0.
      The firmware is not loading (again). I currently have
      no incentive to fix as my Duovero projects only need
      ethernet.

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

    poky 0275e68
    meta-openembedded aad5b3d
    meta-security 27ddb45
    meta-jumpnow b148cd8


meta-duovero layer maintainer: Scott Ellis <scott@jumpnowtek.com>


Note: wifi broke again somewhere between 4.19 and 5.0.
      The firmware is not loading (again). I currently have
      no incentive to fix as my Duovero projects only need
      ethernet.

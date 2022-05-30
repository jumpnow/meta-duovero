This layer depends on:

    URI: git://git.yoctoproject.org/poky.git
    branch: kirkstone 

    URI: git://git.openembedded.org/meta-openembedded
    branch: kirkstone

    URI: git://git.yoctoproject.org/meta-security.git
    branch: kirkstone

Latest commits:

    poky 00c04394cb
    meta-openembedded 0b7836265
    meta-security d3d8e62

meta-duovero layer maintainer: Scott Ellis <scott@jumpnowtek.com>

Note: wifi broke again somewhere between 4.19 and 5.0.
      The firmware is not loading (again). I currently have
      no incentive to fix as my Duovero projects only need
      ethernet.

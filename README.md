This layer depends on:

    URI: git://git.yoctoproject.org/poky.git
    branch: honister 

    URI: git://git.openembedded.org/meta-openembedded
    branch: honister

    URI: git://git.yoctoproject.org/meta-security.git
    branch: honister

Latest commits:

    poky ff138c3ae9
    meta-openembedded f632403d1
    meta-security fb77606

meta-duovero layer maintainer: Scott Ellis <scott@jumpnowtek.com>

Note: wifi broke again somewhere between 4.19 and 5.0.
      The firmware is not loading (again). I currently have
      no incentive to fix as my Duovero projects only need
      ethernet.

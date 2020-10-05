This layer depends on:

    URI: git://git.yoctoproject.org/poky.git
    branch: dunfell

    URI: git://git.openembedded.org/meta-openembedded
    branch: dunfell

    URI: git://git.yoctoproject.org/meta-security.git
    branch: dunfell

    URI: https://github.com/jumpnow/meta-jumpnow.git
    branch: dunfell

Latest commits:

    poky 012ad10a89
    meta-openembedded 144077083
    meta-security d4ec0d8
    meta-jumpnow f7fba93

meta-duovero layer maintainer: Scott Ellis <scott@jumpnowtek.com>

Note: wifi broke again somewhere between 4.19 and 5.0.
      The firmware is not loading (again). I currently have
      no incentive to fix as my Duovero projects only need
      ethernet.

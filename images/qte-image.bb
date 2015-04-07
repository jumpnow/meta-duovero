SUMMARY = "A development image with Qt embedded and some Syntro apps"
HOMEPAGE = "http://www.jumpnowtek.com"
LICENSE = "MIT"

require console-image.bb

PR = "0"

QT_TOOLS = " \
    qt4-embedded \
    qt4-embedded-dev\
    qt4-embedded-plugin-mousedriver-tslib \
 "

IMAGE_INSTALL += " \
    ${QT_TOOLS} \
    psplash \
 "

export IMAGE_BASENAME = "qte-image"


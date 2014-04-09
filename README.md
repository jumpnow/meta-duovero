This layer depends on:

        URI: git://git.yoctoproject.org/poky.git
        branch: dora
        revision: HEAD
        commit: 609ae39 

        URI: git://git.openembedded.org/meta-openembedded
        branch: dora
        revision: HEAD
        commit: 40e0f37

        meta-duovero layer maintainer: Scott Ellis <scott@jumpnowtek.com>

#### Note 

I removed the `meta-gumstix` dependency.

Gumstix recently opted to disable the `uap0` interface from their
kernel because of userland issues. It seems `NetworkManager` gets
confused with multiple wireless interfaces.

[uap-disable-patch - commit d82b49][uap-disable-patch]

"WTF you say?"

`uap0` is the wifi access point interface and I have customers
using the `Duovero` as an AP. That's a bit of a regression.

Removing the dependency on `meta-gumstix` has been something I've 
been meaning to do for awhile.  

Now is a good time.

I'll be working to migrate existing customers off 
`meta-gumstix` as soon as it's feasible.

It was only u-boot and the kernel recipes that I was using from
`meta-gumstix` and both of those pull from mainline repositories
for their source.

The new u-boot and the kernel recipes I added to `meta-duovero` 
continue to pull from the same upstream locations as before.

And I am continuing to use *most* of the same patches the old 
`meta-gumstix` recipes used with a few of my own patches added.

The big functional difference with the new `meta-duovero` layer
was to make `hard-floating` point the default. It's what most 
customers ask for anyway. You can see this in the new 
`conf/machine/duovero.conf`.

To go back to `soft-float`, add a line like this in your 
`local.conf`

        DEFAULTTUNE = "armv7a-neon"

The kernel is still 3.6 (3.6.11)

U-boot did move to 2014.01. There are some new `SPL` warnings that
can be disregarded. 

It's a *TODO* to look into this.

Sorry about this change, but if you were using `meta-duovero` my 
suggestion is you whack

* TMPDIR
* sstate-cache
* cache
  
and build again.

Make sure to look at the latest `conf/local.conf-sample` and
`conf/bblayers.conf-sample` and update your versions accordingly.

If this is your first build, it's no problem.

More instructions can be found at [jumpnowtek.com][duovero-yocto-build]

[uap-disable-patch]: https://github.com/gumstix/meta-gumstix/commit/d82b49bfbbd4e35271ab928f1217636f86725d95
[duovero-yocto-build]: http://www.jumpnowtek.com/gumstix/duovero/Duovero-Systems-with-Yocto.html


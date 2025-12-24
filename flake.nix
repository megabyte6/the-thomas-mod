{
  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";
    flakeUtils.url = "github:numtide/flake-utils";
  };

  outputs = {
    nixpkgs,
    flakeUtils,
    ...
  }:
    flakeUtils.lib.eachDefaultSystem (system: let
      pkgs = import nixpkgs {inherit system;};

      jdk = pkgs.javaPackages.compiler.temurin-bin.jdk-25;
      libs = with pkgs; [
        mesa
        libGL
        udev
        pipewire
        flite

        xorg.libX11
        xorg.libXi
        xorg.libXrandr
        xorg.libXcursor
      ];
    in {
      devShells.default = pkgs.mkShell {
        packages = with pkgs;
          [
            jdk

            git
          ]
          ++ libs;

        env.JAVA_HOME = jdk;
        env.LD_LIBRARY_PATH = pkgs.lib.makeLibraryPath libs;
      };
    });
}

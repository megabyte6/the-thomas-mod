{
  inputs.nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";

  outputs = {nixpkgs, ...}: let
    system = "x86_64-linux";
    pkgs = import nixpkgs {inherit system;};
    libs = [
      pkgs.mesa
      pkgs.libGL

      pkgs.xorg.libX11
      pkgs.xorg.libXrandr
      pkgs.xorg.libXcursor
      pkgs.xorg.libXi
      pkgs.xorg.libXext
      pkgs.xorg.libXxf86vm
    ];
  in {
    devShells.${system}.default = pkgs.mkShell {
      packages =
        [
          pkgs.javaPackages.compiler.temurin-bin.jdk-25
        ]
        ++ libs;
      shellHook = ''
        export LD_LIBRARY_PATH="${pkgs.lib.makeLibraryPath libs}:$LD_LIBRARY_PATH"
      '';
    };
  };
}

# The Thomas Mod

The Thomas Mod is a Minecraft mod that adds items and features relating to Thomas and Friends to the game.

## Features

- Adds a new item: Thomas Ingot
- Custom item group for Thomas items

## Requirements

- Minecraft 1.21.4
- Fabric Loader 0.16.9
- Fabric API 0.114.0+1.21.4
- Mod Menu 13.0.0

## Installation

1. Download and install [Fabric Loader](https://fabricmc.net/use/).
2. Download the latest release of the Thomas Mod from [Modrinth](https://modrinth.com/project/the-thomas-mod) or the [Releases page](https://github.com/megabyte6/TheThomasMod/releases/latest).
3. Place the downloaded `.jar` file into the `mods` folder of your Minecraft directory.
4. Launch Minecraft with the Fabric profile.

## Development

### Prerequisites

- Java Development Kit (JDK) 21
- IntelliJ IDEA or another IDE with Gradle support

### Building from Source

1. Clone the repository:
    ```sh
    git clone https://github.com/megabyte6/TheThomasMod.git
    cd TheThomasMod
    ```
2. Build the project using Gradle:
    ```sh
    ./gradlew build
    ```
3. The built `.jar` file will be located in the `build/libs` directory.

### Running in Development Environment

1. Open the project in IntelliJ IDEA.
2. Run `./gradlew genSources` to generate Minecraft source code.
3. Run `./gradlew runClient` to start Minecraft with the mod.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request on GitHub.

## License

This project is licensed under the GPL-3.0 License. See the [LICENSE](LICENSE) file for details.
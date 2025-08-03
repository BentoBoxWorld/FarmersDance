# 🕺 Farmer’s Dance Addon for BentoBox
[![Discord](https://img.shields.io/discord/272499714048524288.svg?logo=discord)](https://discord.bentobox.world)
[![Build Status](https://ci.codemc.io/buildStatus/icon?job=BentoBoxWorld/TwerkingPlants)](https://ci.codemc.io/job/BentoBoxWorld/job/FarmersDance/)


Dance your crops to life!
The Farmer’s Dance addon allows players to speed up plant growth by “twerking” (rapid sneaking) near crops on their island. Unlike other addons, this one supports a wide range of growable plants—everything from wheat and carrots to cactus, pumpkins, and mushrooms.


## 🚀 Features

* Stimulate plant growth by sneaking repeatedly near them
* Works with all growable plants, not just saplings
* Fully configurable via flags per island
* Lightweight and optimized for BentoBox environments
* Compatible with modern Minecraft versions

## 📦 Installation

1. Download the latest FarmersDance.jar file
2.	Place it in the /addons folder inside your BentoBox server directory
3.	Restart your server
4.	Use /is settings or island flags to enable or disable the feature for players

## ⚙️ Configuration & Flags

The Farmer’s Dance addon is highly configurable to suit different gameplay styles and server performance needs. The configuration file is located at:

`/plugins/BentoBox/addons/FarmersDance/config.yml`

Note: This file is saved on server shutdown. Restarting the server is required for some options (like lazy-dancing) to take effect. Reloading won’t work.

⸻

### 🕺 Dance Settings

* lazy-dancing:
Toggle between two dance modes:
* false (default): Requires players to repeatedly press Shift
* true: Players can simply hold Shift to trigger growth
(Server restart required after changing)
* minimal-dance-moves:
Number of Shift presses needed before plants start growing.
* Default: 3
* maximal-dance-moves:
Max number of dance moves that can be stored per player.
* Excess moves decay at 1 per second
* Helps prevent abuse via rapid sneaking
* Default: 8

⸻

🌾 Affected Area
* affected-radius:
Radius (in blocks) on the X/Z plane where dancing can affect plants.
* Default: 3
* affected-height:
Vertical range of effect.
* 0: Only at player level
* 1: Includes 1 block above and below
* Default: 0
* affected-block-count:
Number of blocks affected per game tick per player.
* Default: 1


### 🌱 Growable Plant Groups

Toggle which plant types are affected by dancing. All are true by default unless noted:

| Config Option           | Affected Plants                                                          | Default   |
| ----------------------- | ------------------------------------------------------------------------ | --------- |
| `grow-saplings`         | All tree saplings, mangrove propagules, azaleas, bamboo                  | true      |
| `grow-crops`            | Wheat, carrots, potatoes, beetroots                                      | true      |
| `grow-pumpkin-melon`    | Stems will grow and force produce pumpkins/melons                        | true      |
| `grow-cactus-sugarcane` | Increases height by 1, max limited to `cactus-size`/`sugar-cane-size`    | true      |
| `grow-mushrooms`        | Red and brown mushrooms (huge mushrooms still require normal conditions) | true      |
| `grow-fungus`           | Warped and crimson fungus (large fungus still requires conditions)       | true      |
| `grow-nether-vines`     | Warped and twisted vines                                                 | true      |
| `grow-vines`            | Regular vines and glow lichen                                            | true      |
| `grow-tall-flowers`     | Tall flowers and pink petals drop items as if bonemealed                 | true      |
| `grow-sea-pickles`      | Grows when requirements are met                                          | true      |
| `grow-kelp-drip-leaf`   | Kelp and large drip leaf                                                 | true      |
| `grow-chorus-flower`    | Grows into a full chorus tree                                            | true      |
| `grow-berries`          | Sweet berries and glow berries produce berries                           | true      |
| `grow-spore-blossoms`   | Spore blossoms drop new blossoms                                         | **false** |


### 🌵 Growth Size Limits

Control how tall some plants can grow from dancing:
* cactus-size: Max cactus height (default: 3)
* sugar-cane-size: Max sugar cane height (default: 3)

## 📚 Documentation

See the 📖 [Farmers Dance Docs Page](https://docs.bentobox.world/en/latest/addons/FarmersDance/)

## 💬 Need Help?

Join our BentoBox Discord community for support, updates, and discussion.

## 🤝 Credits

Inspired by Twerking for Trees, expanded for all crops in the BentoBox ecosystem, written by BONNe.




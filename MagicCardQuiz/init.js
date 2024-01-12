db = db.getSiblingDB('MagicCardQuiz');

db.createCollection("statistics");
db.createCollection("cards");

db.cards.insertMany([
    {
        "name": "Baneslayer Angel",
        "type": "Creature",
        "rarity": "Mythic Rare",
        "cost": 5,
        "power": 5,
        "toughness": 5
    },
    {
        "name": "Grim Lavamancer",
        "type": "Creature",
        "rarity": "Rare",
        "cost": 1,
        "power": 1,
        "toughness": 1
    },
    {
        "name": "Troll Ascetic",
        "type": "Creature",
        "rarity": "Rare",
        "cost": 3,
        "power": 3,
        "toughness": 2
    },
    {
        "name": "Plated Slagwurm",
        "type": "Creature",
        "rarity": "Uncommon",
        "cost": 8,
        "power": 8,
        "toughness": 8
    },
    {
        "name": "Silverblade Paladin",
        "type": "Creature",
        "rarity": "Rare",
        "cost": 3,
        "power": 2,
        "toughness": 2
    },
    {
        "name": "Spectral Lynx",
        "type": "Creature",
        "rarity": "Uncommon",
        "cost": 1,
        "power": 2,
        "toughness": 1
    },
    {
        "name": "Stormwing Entity",
        "type": "Creature",
        "rarity": "Rare",
        "cost": 3,
        "power": 3,
        "toughness": 3
    },
    {
        "name": "Grizzly Bears",
        "type": "Creature",
        "rarity": "Common",
        "cost": 2,
        "power": 2,
        "toughness": 2
    },
    {
        "name": "Chandra's Phoenix",
        "type": "Creature",
        "rarity": "Mythic Rare",
        "cost": 3,
        "power": 2,
        "toughness": 2
    },
    {
        "name": "Dragonlord Silumgar",
        "type": "Creature",
        "rarity": "Mythic Rare",
        "cost": 6,
        "power": 3,
        "toughness": 5
    },
    {
        "name": "Ghor-Clan Rampager",
        "type": "Creature",
        "rarity": "Uncommon",
        "cost": 4,
        "power": 4,
        "toughness": 4
    },
    {
        "name": "Elvish Mystic",
        "type": "Creature",
        "rarity": "Common",
        "cost": 1,
        "power": 1,
        "toughness": 1
    },
    {
        "name": "Spectral Lynx",
        "type": "Creature",
        "rarity": "Uncommon",
        "cost": 1,
        "power": 2,
        "toughness": 1
    },
    {
        "name": "Thragtusk",
        "type": "Creature",
        "rarity": "Mythic Rare",
        "cost": 5,
        "power": 5,
        "toughness": 3
    },
    {
        "name": "Baneslayer Angel",
        "type": "Creature",
        "rarity": "Mythic Rare",
        "cost": 5,
        "power": 5,
        "toughness": 5
    },
    {
        "name": "Grim Lavamancer",
        "type": "Creature",
        "rarity": "Rare",
        "cost": 1,
        "power": 1,
        "toughness": 1
    },
    {
        "name": "Troll Ascetic",
        "type": "Creature",
        "rarity": "Rare",
        "cost": 3,
        "power": 3,
        "toughness": 2
    },
    {
        "name": "Plated Slagwurm",
        "type": "Creature",
        "rarity": "Uncommon",
        "cost": 8,
        "power": 8,
        "toughness": 8
    },
    {
        "name": "Silverblade Paladin",
        "type": "Creature",
        "rarity": "Rare",
        "cost": 3,
        "power": 2,
        "toughness": 2
    }
]);

print("Initialization completed.");

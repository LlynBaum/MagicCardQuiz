db = db.getSiblingDB('MagicCardQuiz');

db.createCollection("cards");
db.createCollection("achievements");
db.createCollection("statistics");

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

db.achievements.insertMany([
    {
        "id": 1,
        "name": "First Game",
        "description": "Play your first game",
        "users": []
    },
    {
        "id": 2,
            "name": "100% Correct",
        "description": "Answer all questions correctly",
        "users": []
    },
    {
        "id": 3,
        "name": "100% Wrong",
        "description": "Answer all questions incorrectly",
        "users": []
    },
    {
        "id": 4,
        "name": "10 Games",
        "description": "Play 10 games",
        "users": []
    },
    {
        "id": 5,
        "name": "Speedrunner",
        "description": "Answer all questions in under 25 seconds",
        "users": []
    },
    {
        "id": 6,
        "name": "Slowpoke",
        "description": "Answer all questions in over 2 minutes",
        "users": []
    },
    {
        "id": 7,
        "name": "warp speed",
        "description": "Answer one question in under 1 second",
        "users": []
    },
    {
        "id": 8,
        "name": "The Flash",
        "description": "Answer all questions in under 1 minute",
        "users": []
    },
    {
        "id": 9,
        "name": "Cheater",
        "description": "Answer all questions correctly in under 5 seconds",
        "users": []
    },
    {
        "id": 10,
        "name": "Identity Crisis",
        "description": "Answer all questions incorrectly in under 5 seconds",
        "users": []
    }
]);

print("Initialization completed.");

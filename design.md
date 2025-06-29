Hello, this is my better Minecraft desgin in concepts!
I am not an experienced Minecraft mod developer. So these concepts may never be realized.
But if you find it fun, you can help me implement it.

# Principles of the design
## Independent of the vanilla game. A design from ground up. But is implemented through the game.
## An incremental development model

# Ideas
- Light is temporary, and mobs spawn at darkness
  - Sleeping is simply banned, and days and nights can have random lengths
  - So the torch block have a duration when destroyed it becomes sticks, when timeout it disappears
    And torch blocks can be carries
  - Coals should be in some way limited
  - You may get eternal light in the nether, so overworld is Minecraft's level 1 (nether involves other challenges than darkness)
- Crafting
  - Crafting is mostly not needed!!!!!
	Don't do meaningless crafting. And the craft table should be revised. 
	Let's not dive deep into this. Crafting is simply then of no delay and requiring no ingredient table.
	And we don't need a crafting table. Just craft in the bag.
- Property of blocks
  - Solid blocks :: hardness, running speed, burnable, sliding
    - Dirt :: greater maximum speed, soft, drop when wet, burn to dry
	- Stone :: hard, slower speed
	- Wood :: medium hardness, medium speed, burnable
  - Fluid blocks
  - Gas/Air blocks
- Better combat
  - Health restoration
	Health cannot be naturally restored! Or one health per day! At the dawn!
	Potions are needed for health restoration!
  - Death penalty
	Items will drop but mobs are more able to acquire them!
  - Mobs should spawn everywhere not always distant to the player
  - There are different kinds of mobs to counter players' strategies
	- [ ] Zombies
    - Zombies are the basic mob with different types of speed, some may not take knockback
    - Spiders can get high, maybe give some spiders a high jump
    - Shields cannot be used, shield is boring, maybe delete skeletons because slow projectiles are then
      not very natural while fast ones may probably be not good in the system
    - Creepers should give loud noise, because quiet creepers do not make the game challenging but only suprising
  - So in the block world, players may get these types of tactics to counter
    - Unreachable places
      - High ground : this should be dealt with by high jump spiders and limited light source
      - Blocked rooms : this should be dealt with creepers from outside
        So there should be a kind of creepers who know where players are even when they are not in sight
      - Places surrounded by traps : environmental damages should be reduced, so 
        Spiderwebs, lava, iron and steel (this light source should be somehow banned), etc should be nerfed
- The progress system in the overworld:
  - Armors should be less, but restoration could be more complex and poisons
  - An eternal light source should be found at some challenging dark place

| Monster | Speed           | Knockback | Description                  |
|---------|-----------------|-----------|------------------------------|
| Zombie  | slow, walk, run | None      | Close-range counter-player   |
| Creeper | slow            | None      | Close-range counter-building |

## Combat system
- Player: HP 5
- Close-range mobs
  - slow speed HP 2 ATK 1, no knockback
  - middle speed HP 1 ATK 1
  - high speed HP 1 ATK 2
- Counter-structure mobs
  - slow speed HP 3 ATK 1 for mobs 2 for player, noisy, no knockback
  - explosive, chain ignition

# Features to implement
- LivingEntity modification
  - [x] Speed getter setter
  - [ ] Knockback

# Java IDE functionalities implemented for Emacs
- Flymake
- Find definitions -- just use a tag tool

package rpg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
	private List<Hero> heroes;
	private List<Enemy> enemies;
	private int playerTurn;
	private int nbTurn;
	private Scanner sc = new Scanner(System.in);
	
	public Game(int nbTurn) {
		System.out.println("A combien voulez-vous jouer ?");
		this.playerTurn = sc.nextInt();
		this.nbTurn = nbTurn;
		boolean finish = true;
		
		generateGame();
		for (int i = 0 ; i < this.nbTurn ; i++) {
			generateCombat(i);
			finish = playGame(i);
			if (finish == false)
				break;
			else {
				upgrade();
			}
		}
		if (finish)
			System.out.println("Bravo c'est gagne");
		else
			System.out.println("Les heros ont perdu");
	}
	
	public void upgrade() {
		int decision;
		
		for (int i = 0 ; i < this.heroes.size() ; i++) {
			System.out.println("Amelioration du " + i + " - Guerrier");
			System.out.println("Que voulez-vous faire ? 1 pour ameliorer l'attaque, 2 pour l'armure, 3 pour avoir une nouvelle potion,"
					+ " 4 pour avoir un lambas, 5 pour regenerer 2 PV, 6 pour regenerer des fleches / mana (pas pour le guerrier),"
					+ " 7 pour ameliorer l'efficacite des potions, 8 pour ameliorer l'efficacite de la nourriture et 9 pour diminuer de 1 les couts des sorts (Mage et Healer)");
			decision = sc.nextInt();
			switch (decision) {
				case 1:
					heroes.get(i).setWeaponDamage(heroes.get(i).getWeaponDamage() + 1);
					break;
				case 2:
					heroes.get(i).setArmor(heroes.get(i).getArmor() + 1);
					break;
				case 3:
					heroes.get(i).addPotion();
					break;
				case 4:
					heroes.get(i).addLambas();
					break;
				case 5:
					heroes.get(i).setLifePoints(heroes.get(i).getLifePoints() + 2);
					break;
				case 6:
					if (heroes.get(i).getName() == "Chasseur") {
						Hunter hunter = (Hunter) heroes.get(i);
						hunter.setArrows(hunter.getArrows() + 2);
					} else if (heroes.get(i).getName() == "Mage" || heroes.get(i).getName() == "Healer") {
						SpellCaster spellCaster = (SpellCaster) heroes.get(i);
						spellCaster.setManaPoints(spellCaster.getManaPoints() + 20);
					} else {
						System.out.println("C'est un guerrier, il ne se passe donc rien");
					}
					break;
				case 7:
					heroes.get(i).betterEfficiencyPotion();
					break;
				case 8:
					heroes.get(i).betterEfficiencyLembas();
					break;
				case 9:
					SpellCaster spellCaster = (SpellCaster) heroes.get(i);
					spellCaster.setManaCostSpell(spellCaster.getManaCostSpell() - 1);
					if (spellCaster.getManaCostSpell() < 0) {
						spellCaster.setManaCostSpell(0);
						System.out.println("Le cout en mana du sort est inferieur a 0, il est donc retablit a 0");
					}
					break;
				default:
					System.out.println("Vous ne faites rien");
					break;
			}
			
		}
	}
	
	public boolean playGame(int turn) {
		Collections.shuffle(heroes);
		Collections.shuffle(enemies);
		int i = 0;
		int decision;
		int decision2;

		while (endEnemies() && endHeroes()) {
			boolean defend = false;
			
			System.out.println();
			System.out.println("Le tour " + turn + " va commencer !");
			System.out.println("Voici la composition : ");
			for (int j = 0 ; j < playerTurn ; j++) {
				heroes.get(j).print();
			}
			
			System.out.println("C'est au tour du " + i + " - " + heroes.get(i).name);
			System.out.println("Voici les ennemies : ");
			for (int j = 0 ; j < enemies.size() ; j++) {
				System.out.print(j + " - ");
				enemies.get(j).print();
			}			
			
			System.out.println("Que veux-tu faire ? 1 pour attaquer / soigner, 2 de se defendre, 3 pour prendre une potion (+3 PV + en fonction des amelioration) et 4 pour manger du lembas (+2 PV + en fonction des amelioration)");
			decision = sc.nextInt();
			switch (decision) {
				case 1:
					if (heroes.get(i).getName().equals("Guerrier")
							|| heroes.get(i).getName().equals("Mage")
							|| heroes.get(i).getName().equals("Chasseur"))
					{
						System.out.println("Qui voulez vous attaquer ?");
						decision2 = sc.nextInt();
						if (decision2 >= 0 && decision2 < enemies.size()) {
							if (enemies.get(decision2).getLifePoints() <= 0) {
								System.out.println("Cette cible n'a plus de vie, recommencez");
								continue;
							}
							if (heroes.get(i).getName().equals("Mage")) {
								SpellCaster spellCaster = (SpellCaster) heroes.get(i);
								if (spellCaster.getManaPoints() < spellCaster.getManaCostSpell()) {
									System.out.println("Pas assez de points de mana, faites une autre action");
									continue;
								}
								enemies.get(decision2).setLifePoints(enemies.get(decision2).getLifePoints() - heroes.get(i).getWeaponDamage());
								if (enemies.get(decision2).getLifePoints() < 0) {
									System.out.println("L'ennemi a ete vaincu, bravo !");
									enemies.get(decision2).setLifePoints(0);
								}
								
							} else if (heroes.get(i).getName().equals("Chasseur")) {
								Hunter hunter = (Hunter) heroes.get(i);
								if (hunter.getArrows() < 1) {
									System.out.println("Pas assez de fleches, faites une autre action");
									continue;
								}
								enemies.get(decision2).setLifePoints(enemies.get(decision2).getLifePoints() - heroes.get(i).getWeaponDamage());
								if (enemies.get(decision2).getLifePoints() < 0) {
									System.out.println("L'ennemi a ete vaincu, bravo !");
									enemies.get(decision2).setLifePoints(0);
								}
								
							} else {
								enemies.get(decision2).setLifePoints(enemies.get(decision2).getLifePoints() - heroes.get(i).getWeaponDamage());
								if (enemies.get(decision2).getLifePoints() < 0) {
									System.out.println("L'ennemi a ete vaincu, bravo !");
									enemies.get(decision2).setLifePoints(0);
								}
								
							}
						} else {
							System.out.println("Vous avez rate votre cible, recommencez");
							continue;
						}
					}
					else {
						System.out.println("Qui voulez vous soigner ?");
						decision2 = sc.nextInt();
						if (decision2 >= 0 && decision2 < heroes.size()) {
							SpellCaster spellCaster = (SpellCaster) heroes.get(i);
							if (heroes.get(decision2).getLifePoints() > 0 && spellCaster.getManaPoints() >= spellCaster.getManaCostSpell()) {
								heroes.get(decision2).setLifePoints(heroes.get(decision2).getLifePoints() + heroes.get(i).getWeaponDamage());
								spellCaster.setManaPoints(spellCaster.getManaPoints() - spellCaster.getManaCostSpell());
							} else {
								System.out.println("Vous ne pouvez pas soigner un hero mort ou vous ne pouvez pas soigner si vous avez moins de " + spellCaster.getManaCostSpell() + " Points de Mana, recommencez");
								continue;
							}
						} else {
							System.out.println("Vous avez rate votre cible, recommencez");
							continue;
						}
					}
					break;
				case 2:
					defend = true;
					break;
				case 3:
					if (heroes.get(i).getNbPotions() > 0)
						heroes.get(i).setLifePoints(heroes.get(i).getLifePoints() + heroes.get(i).getPotionHealingPoint());
					else {
						System.out.println("Vous n'avez pas de potion dans votre sac, recommencez en faisant une autre action");
						continue;
					}
					heroes.get(i).removePotion();
					break;
				case 4:
					if (heroes.get(i).getNbLembas() > 0)
						heroes.get(i).setLifePoints(heroes.get(i).getLifePoints() + + heroes.get(i).getLembasHealingPoint());
					else {
						System.out.println("Vous n'avez pas de nourriture dans votre sac, recommencez en faisant une autre action");
						continue;
					}
					heroes.get(i).removeLembas();
					break;
				default:
					continue;
			}
			
			if (enemies.get(i).getLifePoints() <= 0) {
				System.out.println("L'ennemi est mort, il ne peut donc pas attaquer");
			} else if (defend == true) {
				System.out.println("Le hero se defend et ne prend donc pas de degats");
			} else {
				
				int damage = enemies.get(i).getStrenght() + heroes.get(i).getArmor() / 2;
				if (damage < 0)
					damage = 0;
				heroes.get(i).setLifePoints(heroes.get(i).getLifePoints() - damage);
				if (heroes.get(i).getLifePoints() < 0) {
					heroes.get(i).setLifePoints(0);
					System.out.println("Le hero "+ i + " - " + heroes.get(i).getName() + "est mort, tue par un ennemi");
				}
					
			}
			
			i++;
			if (i >= heroes.size())
				i = 0;
		}
		
		if (endEnemies())
			return true;
		return false;
	}
	
	public boolean endEnemies() {
		for (int i = 0 ; i < enemies.size(); i++) {
			if (enemies.get(i).lifePoints > 0)
				return true;
		}
		return false;
	}
	
	public boolean endHeroes() {
		for (int i = 0 ; i < heroes.size(); i++) {
			if (heroes.get(i).lifePoints > 0)
				return true;
		}
		return false;
	}
	
	public void generateGame() {
		heroes = new ArrayList<Hero>();
		int hero;
		
		for (int i = 0 ; i < playerTurn ; i++) {
			System.out.println("Tapez 1 pour etre Guerrier, 2 pour etre Mage, 3 pour etre Healer et 4 pour etre Chasseur");
			hero = sc.nextInt();
			switch(hero) {
				case 1:
					heroes.add(new Warrior());
					break;
				case 2:
					heroes.add(new Mage());
					break;
				case 3:
					heroes.add(new Healer());
					break;
				case 4:
					heroes.add(new Hunter());
					break;
				default:
					System.out.println("Choix incorrect, un Guerrier vous sera attribue");
			        break;
			}
		}
	}
	
	public void generateCombat(int turn) {
		enemies = new ArrayList<Enemy>();
		for (int i = 0 ; i < this.playerTurn - 1 ; i++) {
			enemies.add(new BasicEnemy(i, this.playerTurn));
		}
		enemies.add(new Boss(turn + 2, this.playerTurn));
	}
}

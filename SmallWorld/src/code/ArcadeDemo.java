
/**
 * Class ArcadeDemo
 * This class contains demos of many of the things you might
 * want to use to make an animated arcade game.
 * 
 * Adapted from the AppletAE demo from years past. 
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.sound.sampled.Clip;

public class ArcadeDemo extends AnimationPanel {
    int turn = 1;
    // 1 = selecting
    // 2= Conquering
    // 3 = Redeployment
    int phase = 1;
    ArrayList<Tile> borders1 = new ArrayList<Tile>();
    ArrayList<Tile> tilesOwned1 = new ArrayList<Tile>();
    ArrayList<Tile> bord = new ArrayList<Tile>();
    ArrayList<String> races = new ArrayList<String>();
    ArrayList<String> abilities = new ArrayList<String>();
    ArrayList<Integer> moneyInSlots = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0));
    String race1;
    String ability1;
    int charactersAvailable1 = 0;
    int money1 = 05;
    String race2;
    String ability2;
    int charactersAvailable2 = 0;
    int money2 = 5;
    ArrayList<Tile> borders2 = new ArrayList<Tile>();
    ArrayList<Tile> tilesOwned2 = new ArrayList<Tile>();
    HashMap<String, Integer> characterAmounts = new HashMap<String, Integer>();

    // Constructor
    // -------------------------------------------------------
    public void makeBoard() {

        Tile water1 = new Tile(0, 0, 180, 100, 0, false, true, true, false, false);
        Tile field1 = new Tile(218, 0, 120, 176, 0, false, true, false, true, false);
        Tile forest1 = new Tile(357, 0, 126, 106, 0, false, true, false, false, true);
        Tile swamp1 = new Tile(511, 0, 136, 80, 0, false, true, false, false, false);
        Tile grass1 = new Tile(696, 0, 104, 69, 0, false, true, false, false, false);
        Tile grass2 = new Tile(252, 195, 140, 79, 0, false, false, false, false, false);
        Tile mountain1 = new Tile(0, 122, 180, 134, 0, true, true, false, false, false);
        Tile mountain2 = new Tile(515, 114, 149, 100, 0, true, false, false, false, false);
        Tile water2 = new Tile(433, 189, 84, 111, 0, false, false, true, false, false);
        Tile forest2 = new Tile(729, 117, 70, 70, 0, false, true, false, false, true);
        Tile field2 = new Tile(656, 61, 30, 110, 0, false, false, false, true, false);
        Tile field3 = new Tile(0, 251, 228, 100, 0, false, true, false, true, false);
        Tile forest3 = new Tile(272, 295, 220, 110, 0, false, false, false, false, true);
        Tile grass3 = new Tile(658, 190, 60, 140, 0, false, false, false, false, false);
        Tile mountain3 = new Tile(755, 201, 45, 163, 0, true, true, false, false, false);
        Tile swamp2 = new Tile(0, 357, 205, 141, 0, false, true, false, false, false);
        Tile grass4 = new Tile(240, 380, 160, 116, 0, false, true, false, false, false);
        Tile swamp3 = new Tile(420, 420, 100, 80, 0, false, true, false, false, false);
        Tile mountain4 = new Tile(539, 411, 130, 89, 0, true, true, false, false, false);
        Tile swamp4 = new Tile(671, 357, 46, 143, 0, false, true, false, false, false);
        Tile forest4 = new Tile(726, 316, 32, 84, 0, false, true, false, false, true);
        Tile water3 = new Tile(726, 393, 74, 107, 0, false, true, true, true, false);
        Tile field4 = new Tile(538, 216, 117, 190, 0, false, false, false, true, false);

        water1.addNode(field1);
        water1.addNode(mountain1);

        field1.addNode(mountain1);
        field1.addNode(water1);
        field1.addNode(forest1);
        field1.addNode(grass2);

        forest1.addNode(water2);
        forest1.addNode(mountain2);
        forest1.addNode(field1);
        forest1.addNode(swamp1);
        forest1.addNode(grass2);

        swamp1.addNode(forest1);
        swamp1.addNode(grass1);
        swamp1.addNode(mountain2);
        swamp1.addNode(field2);

        grass1.addNode(swamp1);
        grass1.addNode(field2);
        grass1.addNode(forest2);

        mountain1.addNode(water1);
        mountain1.addNode(field1);
        mountain1.addNode(field3);
        mountain1.addNode(grass2);

        grass2.addNode(field1);
        grass2.addNode(water2);
        grass2.addNode(mountain1);
        grass2.addNode(field3);
        grass2.addNode(forest3);

        water2.addNode(grass2);
        water2.addNode(forest1);
        water2.addNode(mountain2);
        water2.addNode(field4);
        water2.addNode(forest2);

        mountain2.addNode(forest1);
        mountain2.addNode(swamp1);
        mountain2.addNode(field2);
        mountain2.addNode(grass3);
        mountain2.addNode(field4);
        mountain2.addNode(water2);

        field2.addNode(swamp1);
        field2.addNode(grass1);
        field2.addNode(mountain2);
        field2.addNode(forest2);
        field2.addNode(grass3);

        forest2.addNode(field2);
        forest2.addNode(grass1);
        forest2.addNode(grass3);
        forest2.addNode(mountain3);

        field3.addNode(mountain1);
        field3.addNode(grass2);
        field3.addNode(forest3);
        field3.addNode(grass4);
        field3.addNode(swamp2);

        forest3.addNode(field3);
        forest3.addNode(grass2);
        forest3.addNode(water2);
        forest3.addNode(field4);
        forest3.addNode(grass4);
        forest3.addNode(swamp3);

        field4.addNode(water2);
        field4.addNode(mountain2);
        field4.addNode(grass3);
        field4.addNode(forest3);
        field4.addNode(swamp3);
        field4.addNode(swamp4);
        field4.addNode(mountain4);

        grass3.addNode(mountain2);
        grass3.addNode(mountain3);
        grass3.addNode(field2);
        grass3.addNode(field4);
        grass3.addNode(forest2);
        grass3.addNode(forest4);
        grass3.addNode(swamp4);

        mountain3.addNode(forest2);
        mountain3.addNode(forest4);
        mountain3.addNode(water3);
        mountain3.addNode(grass3);

        swamp2.addNode(field3);
        swamp2.addNode(grass4);

        grass4.addNode(swamp2);
        grass4.addNode(field3);
        grass4.addNode(forest3);
        grass4.addNode(swamp3);

        swamp3.addNode(grass4);
        swamp3.addNode(forest3);
        swamp3.addNode(field4);
        swamp3.addNode(mountain4);

        mountain4.addNode(swamp3);
        mountain4.addNode(swamp4);
        mountain4.addNode(field4);

        swamp4.addNode(field4);
        swamp4.addNode(mountain4);
        swamp4.addNode(water3);
        swamp4.addNode(grass3);
        swamp4.addNode(forest4);

        forest4.addNode(water3);
        forest4.addNode(swamp4);
        forest4.addNode(grass3);
        forest4.addNode(mountain3);

        water3.addNode(mountain3);
        water3.addNode(forest4);
        water3.addNode(swamp4);

        bord.add(water1);
        bord.add(water2);
        bord.add(water3);
        bord.add(swamp1);
        bord.add(swamp2);
        bord.add(swamp3);
        bord.add(swamp4);
        bord.add(grass1);
        bord.add(grass2);
        bord.add(grass3);
        bord.add(grass4);
        bord.add(field1);
        bord.add(field2);
        bord.add(field3);
        bord.add(field4);
        bord.add(forest1);
        bord.add(forest2);
        bord.add(forest3);
        bord.add(forest4);
        bord.add(mountain1);
        bord.add(mountain2);
        bord.add(mountain3);
        bord.add(mountain4);

    }

    public void makeCombos() {
        races.add("ratman");
        races.add("tritons");
        races.add("humans");
        races.add("elves");
        abilities.add("wealthy");
        abilities.add("commando");
        abilities.add("flying");
        abilities.add("forest");
        characterAmounts.put("ratman", 8);
        characterAmounts.put("tritons", 6);
        characterAmounts.put("elves", 6);
        characterAmounts.put("humans", 5);
        characterAmounts.put("commando", 4);
        characterAmounts.put("wealthy", 4);
        characterAmounts.put("flying", 5);
        characterAmounts.put("forest", 4);
        for (int i = 0; i < 4; i++) {

            int selectorRaces = (int) Math.floor(Math.random() * (4 - i));
            int selectorAbilities = (int) Math.floor(Math.random() * (4 - i));
            String race = races.get(i);
            String ability = abilities.get(i);

            races.set(i, races.get(selectorRaces));
            abilities.set(i, abilities.get(selectorAbilities));
            races.set(selectorRaces, race);
            abilities.set(selectorAbilities, ability);
        }

    }

    public void makeImages() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        images.put("ratmanPiece", toolkit.getImage("src/images/RatManPiece.png").getScaledInstance(50, 50, 0));
        images.put("humansPiece", toolkit.getImage("src/images/HumanPiece.png").getScaledInstance(50, 50, 0));
        images.put("tritonsPiece", toolkit.getImage("src/images/TritonPiece.png").getScaledInstance(50, 50, 0));
        images.put("elvesPiece", toolkit.getImage("src/images/ElfPiece.png").getScaledInstance(50, 50, 0));
        images.put("ratmanSelector", ratManSelector);
        images.put("humansSelector", humanSelector);
        images.put("tritonsSelector", tritonSelector);
        images.put("elvesSelector", elfSelector);
        images.put("flying", toolkit.getImage("src/images/FlyingAbility.png").getScaledInstance(200, 50, 0));
        images.put("forest", toolkit.getImage("src/images/ForestAbilities.png").getScaledInstance(200, 50, 0));
        images.put("wealthy", toolkit.getImage("src/images/WealthyAbility.png").getScaledInstance(200, 50, 0));
        images.put("commando", toolkit.getImage("src/images/CommandoSelector.png").getScaledInstance(200, 50, 0));

    }

    public ArcadeDemo() { // Enter the name and width and height.
        super("ArcadeDemo", 1200 + 23, 500 + 57);
        makeImages();
        makeCombos();
        makeBoard();
    }

    public void movePhase() {
        phase++;
        if (phase > 3) {
            clicked1 =false;
            clicked2 = false;
            turn++;
            phase = 2;
            if (turn % 2 == 1 && race1 == null) {
                phase = 1;
            } else if (turn % 2 == 0 && race2 == null) {
                phase = 1;
            }
            if (turn % 2 == 1) {
                for (int i = 0; i < tilesOwned1.size(); i++) {
                    charactersAvailable1 += tilesOwned1.get(i).charactersConquering - 1;
                    tilesOwned1.get(i).charactersConquering = 1;
                }
            }
            if (turn % 2 == 0) {
                for (int i = 0; i < tilesOwned2.size(); i++) {
                    charactersAvailable2 += tilesOwned2.get(i).charactersConquering - 1;
                    tilesOwned2.get(i).charactersConquering = 1;
                }
            }

            if (turn % 2 == 0) {
                for (int i = 0; i < bord.size(); i++) {
                    if(bord.get(i).owningPlayer == 1){
                    money1 += bord.get(i).collectMoney(bord.get(i).ability,bord.get(i).race);
                    }
                }
            }

            if (turn % 2 == 1) {
                for (int i = 0; i < bord.size(); i++) {
                    if(bord.get(i).owningPlayer == 0){
                    money2 += bord.get(i).collectMoney(bord.get(i).ability,bord.get(i).race);
                    }
                }
            }
        }
    }

    public void updateBorders() {

        borders1.clear();
        for (int i = 0; i < tilesOwned1.size(); i++) {

            for (int j = 0; j < tilesOwned1.get(i).connectingTiles.size(); j++) {
                borders1.add(tilesOwned1.get(i).connectingTiles.get(j));
            }
        }

        borders2.clear();
        for (int i = 0; i < tilesOwned2.size(); i++) {

            for (int j = 0; j < tilesOwned2.get(i).connectingTiles.size(); j++) {
                borders2.add(tilesOwned2.get(i).connectingTiles.get(j));
            }
        }

    }

    // The renderFrame method is the one which is called each time a frame is drawn.
    // -------------------------------------------------------
    protected void renderFrame(Graphics g) {

        frameNumber++;
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, 1200, 900);
        g.setColor(new Color(0, 196, 52));
        g.fillRect(1100, 450, 100, 100);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", 0, 13));
        g.drawString("Next Phase", 1125, 480);
        g.setColor(Color.WHITE);
        g.drawString("money1:" + money1, 1125, 300);
        g.drawString("money2:" + money2, 1125, 400);

        // draws background
        g.drawImage(map, 0, 0, this);
        g.setColor(Color.GREEN);
        g.fillRect(1000, 450, 100, 50);
        g.setColor(Color.BLACK);
        g.drawString("Decline", 1025, 485);
        for (int i = 0; i < races.size(); i++) {
            g.drawImage(images.get(races.get(i) + "Selector"), 800, i * 50, this);
            g.drawImage(images.get(abilities.get(i)), 1000, i * 50, this);
        }

        for (int i = 0; i < charactersAvailable1; i++) {
            g.drawImage(images.get(race1 + "Piece"), 900 - (i * 8), 450, this);
        }
        for (int i = 0; i < charactersAvailable2; i++) {
            g.drawImage(images.get(race2 + "Piece"), 1100 - (i * 8), 450, this);
        }
        g.drawString(mouseX + "," + mouseY, 100, 100);
        for (int i = 0; i < bord.size(); i++) {
            for (int j = 0; j < bord.get(i).charactersConquering; j++) {

                g.drawImage(images.get(bord.get(i).race + "Piece"), bord.get(i).x + (bord.get(i).width / 5) + 5 * j,
                        bord.get(i).y + (bord.get(i).height / 3), this);
            }
        }

    }// --end of renderFrame method--

    // -------------------------------------------------------
    // Respond to Mouse Events
    // -------------------------------------------------------
    boolean clicked1 = false;

    public void player1Click(MouseEvent e) {

        if (new HitBox(1100, 450, 100, 100).intersects(mouseX, mouseY)) {
            movePhase();
        }

        if (phase == 1) {
            for (int i = 0; i < races.size(); i++) {
                if (new HitBox(800, i * 50, 800, 50).intersects(mouseX, mouseY)) {
                    race1 = races.get(i);
                    ability1 = abilities.get(i);
                    races.remove(i);
                    abilities.remove(i);
                    charactersAvailable1 = characterAmounts.get(race1) + characterAmounts.get(ability1);
                    phase++;
                    money1 += moneyInSlots.get(i);
                    moneyInSlots.remove(i);
                    for (int j = i; j < moneyInSlots.size(); j++) {
                        moneyInSlots.set(j, moneyInSlots.get(j) + 1);
                        money1--;
                    }
                    if (ability1.equals("wealthy")) {
                        money1 += 7;
                    }
                }

            }

        }

        if (phase == 2) {
            if (new HitBox(1000, 450, 100, 50).intersects(mouseX, mouseY) && !clicked1) {
               tilesOwned1.clear();
                charactersAvailable1 = 0;
                race1 = null;
                phase = 4;
            }
            if (tilesOwned1.size() == 0) {

                for (int i = 0; i < bord.size(); i++) {
                    if ((bord.get(i).edgePiece || ability1.equals("flying"))
                            && charactersAvailable1 >= bord.get(i).amountToCaptue(race1, ability1)
                            && bord.get(i).hitBox.intersects(mouseX, mouseY) && !bord.get(i).waterPiece
                            && bord.get(i).owningPlayer != turn % 2) {
                        if (bord.get(i).charactersConquering > 0) {
                            if (bord.get(i).race.equals("elves")) {
                                charactersAvailable2 += bord.get(i).charactersConquering;
                            } else {
                                charactersAvailable2 += bord.get(i).charactersConquering - 1;
                            }
                            tilesOwned2.remove(bord.get(i));
                        }
                        bord.get(i).setRace(race1);
                        bord.get(i).ability = ability1;
                        bord.get(i).owningPlayer = turn % 2;
                        charactersAvailable1 -= bord.get(i).amountToCaptue(race1, ability1);
                        bord.get(i).charactersConquering = bord.get(i).amountToCaptue(race1, ability1);
                        tilesOwned1.add(bord.get(i));
                        updateBorders();
                        clicked1 = true;
                    }
                }
            } else {
                if (ability1.equals("flying")) {
                    for (int i = 0; i < bord.size(); i++) {

                        if ((bord.get(i).edgePiece || ability1.equals("flying"))
                                && charactersAvailable1 >= bord.get(i).amountToCaptue(race1, ability1)
                                && bord.get(i).hitBox.intersects(mouseX, mouseY) && !bord.get(i).waterPiece
                                && bord.get(i).owningPlayer != turn % 2) {
                            if (bord.get(i).charactersConquering > 0) {
                                if (bord.get(i).race.equals("elves")) {
                                    charactersAvailable2 += bord.get(i).charactersConquering;
                                } else {
                                    charactersAvailable2 += bord.get(i).charactersConquering - 1;
                                }
                                tilesOwned2.remove(bord.get(i));
                            }
                            bord.get(i).setRace(race1);
                            bord.get(i).ability = ability1;
                            bord.get(i).owningPlayer = turn % 2;
                            charactersAvailable1 -= bord.get(i).amountToCaptue(race1, ability1);
                            bord.get(i).charactersConquering = bord.get(i).amountToCaptue(race1, ability1);
                            tilesOwned1.add(bord.get(i));
                            updateBorders();
                            clicked1 = true;

                        }
                    }
                } else {
                    for (int i = 0; i < borders1.size(); i++) {
                        if (charactersAvailable1 >= borders1.get(i).amountToCaptue(race1, ability1)
                                && borders1.get(i).hitBox.intersects(mouseX, mouseY) && !borders1.get(i).waterPiece
                                && borders1.get(i).owningPlayer != turn % 2) {
                            if (borders1.get(i).charactersConquering > 0) {
                                if (borders1.get(i).race.equals("elves")) {
                                    charactersAvailable2 += borders1.get(i).charactersConquering;
                                } else {
                                    charactersAvailable2 += borders1.get(i).charactersConquering - 1;
                                }
                                tilesOwned2.remove(borders1.get(i));
                            }
                            borders1.get(i).setRace(race1);
                            borders1.get(i).ability = ability1;

                            borders1.get(i).owningPlayer = turn % 2;
                            charactersAvailable1 -= borders1.get(i).amountToCaptue(race1, ability1);
                            borders1.get(i).charactersConquering = borders1.get(i).amountToCaptue(race1, ability1);
                            tilesOwned1.add(borders1.get(i));
                            updateBorders();
                            clicked1 = true;

                            break;
                        }
                    }
                }
            }
        }
        if (phase == 3) {

            if (e.getButton() == 3) {
                for (int i = 0; i < bord.size(); i++) {

                    if (bord.get(i).owningPlayer == turn % 2 && bord.get(i).hitBox.intersects(mouseX, mouseY)) {
                        bord.get(i).removeCharacters(1);
                        charactersAvailable1++;
                    }
                }
            } else {
                for (int i = 0; i < bord.size(); i++) {
                    if (bord.get(i).owningPlayer == turn % 2 && bord.get(i).hitBox.intersects(mouseX, mouseY)
                            && charactersAvailable1 > 0) {

                        bord.get(i).removeCharacters(-1);
                        charactersAvailable1--;
                    }
                }
            }
        }
    }

    boolean clicked2;

    public void player2Click(MouseEvent e) {
        if (new HitBox(1100, 450, 100, 100).intersects(mouseX, mouseY)) {
            movePhase();
        }

        if (phase == 1) {

            for (int i = 0; i < races.size(); i++) {
                if (new HitBox(800, i * 50, 800, 50).intersects(mouseX, mouseY)) {
                    race2 = races.get(i);
                    ability2 = abilities.get(i);
                    races.remove(i);
                    abilities.remove(i);
                    charactersAvailable2 = characterAmounts.get(race2) + characterAmounts.get(ability2);
                    phase++;
                    money2 += moneyInSlots.get(i);
                    moneyInSlots.remove(i);
                    for (int j = i; j < moneyInSlots.size(); j++) {
                        moneyInSlots.set(j, moneyInSlots.get(j) + 1);
                        money2--;
                    }
                    if (ability2.equals("wealthy")) {
                        money2 += 7;
                    }
                }
            }

        }
        if (phase == 2) {
            if (new HitBox(1000, 450, 100, 50).intersects(mouseX, mouseY) && !clicked2) {
                charactersAvailable2 = 0;
                race2 = null;
                phase = 4;
                tilesOwned2.clear();
            }
            if (tilesOwned2.size() == 0) {

                for (int i = 0; i < bord.size(); i++) {
                    if ((bord.get(i).edgePiece || ability2.equals("flying"))
                            && charactersAvailable2 >= bord.get(i).amountToCaptue(race2, ability2)
                            && bord.get(i).hitBox.intersects(mouseX, mouseY) && !bord.get(i).waterPiece
                            && bord.get(i).owningPlayer != turn % 2) {
                        if (bord.get(i).charactersConquering > 0) {
                            if (bord.get(i).race.equals("elves")) {
                                charactersAvailable1 += bord.get(i).charactersConquering;
                            } else {
                                charactersAvailable1 += bord.get(i).charactersConquering - 1;
                            }
                            tilesOwned1.remove(bord.get(i));
                        }
                        bord.get(i).setRace(race2);
                        bord.get(i).ability = ability2;
                        bord.get(i).owningPlayer = turn % 2;
                        charactersAvailable2 -= bord.get(i).amountToCaptue(race2, ability2);
                        bord.get(i).charactersConquering = bord.get(i).amountToCaptue(race2, ability2);
                        tilesOwned2.add(bord.get(i));
                        updateBorders();
                        clicked2 = true;
                    }
                }
            } else {
                if (ability2.equals("flying")) {
                    for (int i = 0; i < bord.size(); i++) {

                        if ((bord.get(i).edgePiece || ability2.equals("flying"))
                                && charactersAvailable2 >= bord.get(i).amountToCaptue(race2, ability2)
                                && bord.get(i).hitBox.intersects(mouseX, mouseY) && !bord.get(i).waterPiece
                                && bord.get(i).owningPlayer != turn % 2) {
                            if (bord.get(i).charactersConquering > 0) {
                                if (bord.get(i).race.equals("elves")) {
                                    charactersAvailable1 += bord.get(i).charactersConquering;
                                } else {
                                    charactersAvailable1 += bord.get(i).charactersConquering - 1;
                                }
                                tilesOwned1.remove(bord.get(i));
                            }
                            bord.get(i).setRace(race2);
                            bord.get(i).ability = ability2;
                            bord.get(i).owningPlayer = turn % 2;
                            charactersAvailable2 -= bord.get(i).amountToCaptue(race2, ability2);
                            bord.get(i).charactersConquering = bord.get(i).amountToCaptue(race2, ability2);
                            tilesOwned2.add(bord.get(i));
                            updateBorders();
                            clicked2 = true;

                        }
                    }
                } else {
                    for (int i = 0; i < borders2.size(); i++) {
                        if (charactersAvailable2 >= borders2.get(i).amountToCaptue(race2, ability2)
                                && borders2.get(i).hitBox.intersects(mouseX, mouseY) && !borders2.get(i).waterPiece
                                && borders2.get(i).owningPlayer != turn % 2) {
                            if (borders2.get(i).charactersConquering > 0) {
                                if (borders2.get(i).race.equals("elves")) {
                                    charactersAvailable1 += borders2.get(i).charactersConquering;
                                } else {
                                    charactersAvailable1 += borders2.get(i).charactersConquering - 1;
                                }
                                tilesOwned1.remove(borders2.get(i));
                            }
                            borders2.get(i).setRace(race2);
                            borders2.get(i).ability = ability2;
                            borders2.get(i).owningPlayer = turn % 2;
                            charactersAvailable2 -= borders2.get(i).amountToCaptue(race2, ability2);
                            borders2.get(i).charactersConquering = borders2.get(i).amountToCaptue(race2, ability2);
                            tilesOwned2.add(borders2.get(i));
                            updateBorders();
                            clicked2 = true;

                            break;
                        }
                    }
                }
            }
        }
        if (phase == 3) {

            if (e.getButton() == 3) {
                for (int i = 0; i < bord.size(); i++) {

                    if (bord.get(i).owningPlayer == turn % 2 && bord.get(i).hitBox.intersects(mouseX, mouseY)) {
                        bord.get(i).removeCharacters(1);
                        charactersAvailable2++;
                    }
                }
            } else {
                for (int i = 0; i < bord.size(); i++) {
                    if (bord.get(i).owningPlayer == turn % 2 && bord.get(i).hitBox.intersects(mouseX, mouseY)
                            && charactersAvailable2 > 0) {

                        bord.get(i).removeCharacters(-1);
                        charactersAvailable2--;
                    }
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e) {

        if (turn % 2 == 1) {

            player1Click(e);
        } else {
            player2Click(e);
        }

    }

    // -------------------------------------------------------
    // Respond to Keyboard Events
    // -------------------------------------------------------
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();

    }

    public void keyPressed(KeyEvent e) {
        int v = e.getKeyCode();
        if (v == KeyEvent.VK_SHIFT) {

        }

    }

    public void keyReleased(KeyEvent e) {
        int v = e.getKeyCode();

    }

    // -------------------------------------------------------
    // Initialize Graphics
    // -------------------------------------------------------
    // -----------------------------------------------------------------------
    /*
     * Image section...
     * To add a new image to the program, do three things.
     * 1. Make a declaration of the Image by name ... Image imagename;
     * 2. Actually make the image and store it in the same directory as the code.
     * 3. Add a line into the initGraphics() function to load the file.
     * //-----------------------------------------------------------------------
     */

    Image map;
    Image ratManSelector;
    Image humanSelector;
    Image tritonSelector;
    Image elfSelector;
    HashMap<String, Image> images = new HashMap<String, Image>();

    public void initGraphics() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        ratManSelector = toolkit.getImage("src/images/RatmanSelector.png").getScaledInstance(200, 50, 0);
        humanSelector = toolkit.getImage("src/images/HumanSelector.png").getScaledInstance(200, 50, 0);
        tritonSelector = toolkit.getImage("src/images/TritonSelector.png").getScaledInstance(200, 50, 0);
        elfSelector = toolkit.getImage("src/images/ElfSelector.png").getScaledInstance(200, 50, 0);

        map = toolkit.getImage("src/images/Map.png").getScaledInstance(800, 500, 0);

    }
    // --end of initGraphics()--

    // -------------------------------------------------------
    // Initialize Sounds
    // -------------------------------------------------------
    // -----------------------------------------------------------------------
    /*
     * Music section...
     * To add music clips to the program, do four things.
     * 1. Make a declaration of the AudioClip by name ... AudioClip clipname;
     * 2. Actually make/get the .wav file and store it in the same directory as the
     * code.
     * 3. Add a line into the initMusic() function to load the clip.
     * 4. Use the play(), stop() and loop() functions as needed in your code.
     * //-----------------------------------------------------------------------
     */
    Clip themeMusic;
    Clip bellSound;

    public void initMusic() {
        // themeMusic = loadClip("src/audio/theme.wav");

        // if(themeMusic != null)
        // // themeMusic.start(); //This would make it play once!
        // themeMusic.loop(20); //This would make it loop 2 times.
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}// --end of ArcadeDemo class--
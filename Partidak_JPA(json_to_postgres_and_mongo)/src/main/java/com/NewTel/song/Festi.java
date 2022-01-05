package com.NewTel.song;

/**
 * Abestia sortzeko sekuentziak.
 */
public class Festi extends Thread{
    //Soinuak:
    public static Kick kick = new Kick();
    public static Snare snare = new Snare();
    public static Hat hat = new Hat();
    public static Melo melo = new Melo();

    @Override
    public void run() {
        super.run();
        kick.setPriority(Thread.MAX_PRIORITY); //Kick -a abestiaren elementu prinzipala denez prioritatea dauka besteen gainean
        kick.start();
        kick.interrupt();
        hat.start();
        hat.interrupt();
        snare.start();
        snare.interrupt();
        //melo.start();
        //melo.interrupt();
        for (int x = 0; x < 7; x++) {   // 7 konpaseko patroia
            kick.run();
            kick.interrupt();
            for (int i = 0; i < 2; i++) {   //hat -ak belozidade bikoitzean doazte
                hat.run();

                hat.interrupt();
            }


            try {                       //Erritmoa mantzentzen duen denbora (110-120 bpm an dago)
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //snare.run();
            //hat.run();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        kick.run();
        kick.interrupt();
        hat.run();
        hat.interrupt();
        try {                               // redoblea
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            hat.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        snare.run();
        try {
            snare.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hat.run();

        hat.interrupt();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        snare.run();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int x = 0; x < 8; x++) {  //bigarren "patroia"
            if (x == 8) {
                kick.run();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            kick.run();
            kick.interrupt();
            for (int i = 0; i < 2; i++) {
                hat.run();

                hat.interrupt();
            }
            if (x == 8) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            snare.run();

            //redoble bat
            if (x == 3 || x == 7 || x == 15 || x == 11) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                snare.run();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //beste patroi bat
        for (int x = 0; x < 8; x++) {
            if (x == 8) {
                kick.run();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            kick.run();
            kick.interrupt();
            for (int i = 0; i < 2; i++) {
                hat.run();

                hat.interrupt();
            }
            if (x == 8) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            snare.run();
            //hat.run();
            if (x == 3 || x == 7 || x == 15 || x == 11) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                snare.run();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        //Melodia hasten da
        kick.run();
        kick.interrupt();
        melo.start();


        for (int x = 0; x < 16; x++) {
            if (x == 8) {
                kick.run();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (x != 0) {
                kick.run();
                kick.interrupt();
            }

            for (int i = 0; i < 2; i++) {
                hat.run();

                hat.interrupt();
            }
            if (x == 8) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            snare.run();
            //hat.run();
            if (x == 3 || x == 7 || x == 15 || x == 11) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                snare.run();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

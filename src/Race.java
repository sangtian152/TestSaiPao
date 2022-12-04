class Race implements Runnable{
    private static String winner;// 胜利者只有一个，因此使用静态变量

    private Integer sleep = 0;

    private Integer speed = 10;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100 ; i+=speed) {
            // 模拟休息
            if (sleep > 0){
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean result = gameOver(i);// 判断比赛是否结束
            if (result){
                break; // 比赛结束就停止程序
            }
            System.out.println(Thread.currentThread().getName() + " --> 跑了"+i+"米");
        }
    }
    private boolean gameOver(int steps) {
        // 判断是否有胜利者
        if (winner != null) {
            return true;
        }
        // 判断是否跑了100米
        if (steps >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println(winner + " --> 跑了"+steps+"米");
            System.out.println("获胜者是： " + winner);
            return true;
        }
        return false;
    }
}

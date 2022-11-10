package menu.menu;

/**
 * 菜单
 *
 * @author 陶敏帆
 * @version 1.0
 */
abstract public class Menu implements menuMethod{

    private String title;               //菜单标题
    private String[] context;           //菜单内容
    private Menu lastMenu = null;       //上一级菜单

    public Menu() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getContext() {
        return context;
    }

    public void setContext(String... context) {
        this.context = context;
    }

    public Menu getLastMenu() {
        return lastMenu;
    }

    public void setLastMenu(Menu lastMenu) {
        this.lastMenu = lastMenu;
    }

    //编辑及输出标题
    public static void title(String title) {
        System.out.println("----------" + title + "----------");
    }

    //编辑及输出选择内容
    public static void context(String... context) {
        int i = 0;
        for (String s : context) {
            System.out.println("\t\t" + (++i) + "." + s);
        }
    }
}

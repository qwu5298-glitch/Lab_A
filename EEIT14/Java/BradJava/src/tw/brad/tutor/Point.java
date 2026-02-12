package tw.brad.tutor;

/*
 * 1. 全參數建構子
 * 2. 參數就是屬性, final
 * 3. 屬性就是 getter 名稱
 * 4. equals => 針對屬性
 */
public record Point(int x, int y) {}
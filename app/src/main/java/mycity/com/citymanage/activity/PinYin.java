package mycity.com.citymanage.activity;

import android.text.TextUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by Administrator on 2017/12/28.
 */

public class PinYin {
    public static String getPinYin(String name) {

        if (TextUtils.isEmpty(name)) { return null;}
        HanyuPinyinOutputFormat format=new HanyuPinyinOutputFormat();
        /**大写字母*/
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        /**不带发音*/
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);


        StringBuilder sb=new StringBuilder( );
        final char[] chars = name.toCharArray();
        for(char ch:chars){
            /**过滤空格，如果是空格，跳转下一个*/
            if(Character.isWhitespace(ch)){
                continue;
            }
            if(ch>127){


                try {
                    final String[] strings = PinyinHelper.toHanyuPinyinStringArray(ch, format);
                    if(strings!=null&&strings.length>0){
                        /**由于有多音字的存在，目前只能取得第一个*/
                        sb.append(strings[0]);
                    }
                } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                    badHanyuPinyinOutputFormatCombination.printStackTrace();
                }
            }else{
                sb.append(ch);
            }
        }
        return  sb.toString();

    }
}
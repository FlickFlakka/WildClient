package ru.metaculture.sdk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Obfuscate {
    Preset preset() default Preset.DEFAULT;
    boolean const_flow() default false;
    ConstFlow const_flow_type() default ConstFlow.MEDIUM;
    boolean control_flow() default false;
    ControlFlow control_flow_type() default ControlFlow.MIXED;
    boolean string_encrypt() default false;
    StringEncrypt string_encrypt_type() default StringEncrypt.XOR;
    boolean number_encrypt() default false;
    NumberEncrypt number_encrypt_type() default NumberEncrypt.LIGHT;
    boolean invoke_dynamic() default false;
    boolean hide_reflection() default false;
    boolean dead_code() default false;
    DeadCode dead_code_type() default DeadCode.LIGHT;
    boolean junk_code() default false;
    boolean strip_debug() default true;
    boolean watermark() default false;
    String watermark_text() default "";

    enum ConstFlow { LIGHT, MEDIUM, HEAVY }
    enum ControlFlow { SPLIT, FLAT, MIXED }
    enum DeadCode { LIGHT, MEDIUM, HEAVY }
    enum NumberEncrypt { LIGHT, HEAVY }
    enum Preset { DEFAULT, LIGHT, MEDIUM, HEAVY, EXTREME }
    enum StringEncrypt { XOR, AES, RC4, SHACAL2 }
}

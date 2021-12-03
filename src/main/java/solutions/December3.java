package solutions;

import java.util.Scanner;
import java.lang.Math.*;
import java.util.*;

public class December3 {
    public static void main(String[] args) {
        String input = "000110000001\n" +
"011011001101\n" +
"001101100111\n" +
"001101011001\n" +
"110111011101\n" +
"110011101010\n" +
"111101010001\n" +
"010100111101\n" +
"011000011000\n" +
"001110110011\n" +
"001100010110\n" +
"110111101100\n" +
"110001111100\n" +
"001011111100\n" +
"000000011010\n" +
"110101100111\n" +
"011000011111\n" +
"011000000111\n" +
"011111000110\n" +
"100101110111\n" +
"010101001110\n" +
"111101000011\n" +
"010010010110\n" +
"100100011111\n" +
"101011001110\n" +
"001111110000\n" +
"110000011111\n" +
"110000011000\n" +
"011001111100\n" +
"010010001101\n" +
"000111001110\n" +
"110111001110\n" +
"110001010101\n" +
"100111011001\n" +
"000101110000\n" +
"110001011100\n" +
"111101010010\n" +
"101011000001\n" +
"001101001111\n" +
"110111101010\n" +
"101111111000\n" +
"110101000110\n" +
"011111001001\n" +
"001110100001\n" +
"010100110111\n" +
"110100000110\n" +
"101010110010\n" +
"100100101110\n" +
"101111011110\n" +
"000110110101\n" +
"011011110101\n" +
"111001011110\n" +
"110110100111\n" +
"000100010001\n" +
"001101010110\n" +
"100011000110\n" +
"001110010010\n" +
"010111110111\n" +
"011010011101\n" +
"110000011100\n" +
"010100001001\n" +
"000110100000\n" +
"101001010000\n" +
"000001110000\n" +
"101110010011\n" +
"010011100111\n" +
"010011011000\n" +
"110111011111\n" +
"000111010010\n" +
"101010111010\n" +
"111001100100\n" +
"101110100011\n" +
"111101111110\n" +
"010111111000\n" +
"010010001111\n" +
"110010000011\n" +
"001110000010\n" +
"100101111110\n" +
"000100101001\n" +
"101101010000\n" +
"111111010000\n" +
"101010011000\n" +
"011100100001\n" +
"011101101000\n" +
"001010010100\n" +
"010010100011\n" +
"110011111111\n" +
"110100011001\n" +
"111010011110\n" +
"011110001101\n" +
"011010011100\n" +
"100100000001\n" +
"111111001010\n" +
"110100110011\n" +
"110100011111\n" +
"100010001110\n" +
"101000111100\n" +
"100001110010\n" +
"110101010011\n" +
"101010011101\n" +
"011010011010\n" +
"101110101101\n" +
"001100011010\n" +
"101001010101\n" +
"101010000100\n" +
"000110101010\n" +
"100000111100\n" +
"000111111100\n" +
"000001001011\n" +
"010010111100\n" +
"011000111001\n" +
"111010101100\n" +
"010011100010\n" +
"010100110001\n" +
"001100111011\n" +
"101100001111\n" +
"111010101111\n" +
"010001000011\n" +
"000001100010\n" +
"000100001011\n" +
"100110011011\n" +
"101100001110\n" +
"000010110100\n" +
"011000101011\n" +
"010011011100\n" +
"110101010000\n" +
"101101101100\n" +
"101001110000\n" +
"010111010011\n" +
"110101110001\n" +
"011000001000\n" +
"011101010010\n" +
"111011111110\n" +
"010010000110\n" +
"110000111000\n" +
"101000000110\n" +
"011100110000\n" +
"111001111010\n" +
"110000001100\n" +
"101011111110\n" +
"100001111100\n" +
"011011100110\n" +
"101000001101\n" +
"001011110011\n" +
"111100100011\n" +
"101111000111\n" +
"101000000001\n" +
"001001011010\n" +
"010111111010\n" +
"101010111001\n" +
"011110101001\n" +
"101100111101\n" +
"011100000010\n" +
"000110001111\n" +
"111100110101\n" +
"100011100010\n" +
"000110010100\n" +
"011000000011\n" +
"010011001011\n" +
"000001101111\n" +
"101011101101\n" +
"100100100101\n" +
"011001110110\n" +
"010100000000\n" +
"100100010001\n" +
"001100000100\n" +
"100000111010\n" +
"101001011001\n" +
"010010111001\n" +
"110000101010\n" +
"001101010101\n" +
"110110011100\n" +
"010000000011\n" +
"111100011000\n" +
"000101111110\n" +
"100010110101\n" +
"101111010000\n" +
"000010100010\n" +
"101101001010\n" +
"011111000000\n" +
"011000100100\n" +
"110010100110\n" +
"010001110011\n" +
"010101101101\n" +
"001011100000\n" +
"001000110110\n" +
"001000110111\n" +
"110100111110\n" +
"110010110100\n" +
"101010100111\n" +
"000111011001\n" +
"111000101101\n" +
"110000010110\n" +
"010011101010\n" +
"110100111011\n" +
"100110010100\n" +
"100111000011\n" +
"011110111111\n" +
"010010000111\n" +
"111100111110\n" +
"001010111101\n" +
"000011001110\n" +
"000110010101\n" +
"111100110011\n" +
"101111111001\n" +
"101001111011\n" +
"111010110000\n" +
"000001010101\n" +
"100010011001\n" +
"111110110010\n" +
"110100101100\n" +
"100001011110\n" +
"100001000011\n" +
"101111000011\n" +
"101111110100\n" +
"111010000010\n" +
"001010010110\n" +
"010001000110\n" +
"100010000101\n" +
"111101111010\n" +
"000101111111\n" +
"010110110100\n" +
"110111111110\n" +
"011010101011\n" +
"100000110011\n" +
"000000101001\n" +
"010010101111\n" +
"010001001010\n" +
"000101010100\n" +
"101110111010\n" +
"101001000000\n" +
"001010101111\n" +
"011110100110\n" +
"110101011001\n" +
"100111101101\n" +
"110001001001\n" +
"110100001010\n" +
"100100101001\n" +
"110111010011\n" +
"011010001011\n" +
"011001001101\n" +
"110100010001\n" +
"010100001100\n" +
"011011000001\n" +
"110100011100\n" +
"001110111111\n" +
"111001110010\n" +
"001110010000\n" +
"011100001110\n" +
"001111110001\n" +
"001101010111\n" +
"111110011100\n" +
"111100111010\n" +
"010100010100\n" +
"000011001010\n" +
"011110001010\n" +
"111101010011\n" +
"100111001010\n" +
"010110110011\n" +
"000101000000\n" +
"000110011010\n" +
"100100001111\n" +
"000100111111\n" +
"010100010101\n" +
"001110100011\n" +
"100111000100\n" +
"100001101110\n" +
"011010011110\n" +
"001111010101\n" +
"111000001100\n" +
"100111110110\n" +
"101110001100\n" +
"101011000111\n" +
"001010110010\n" +
"100011011100\n" +
"110000010000\n" +
"101001101011\n" +
"111011011000\n" +
"000101101001\n" +
"011001111011\n" +
"101011001111\n" +
"001111111111\n" +
"110000101011\n" +
"111111100011\n" +
"101010101111\n" +
"001001010001\n" +
"011111010001\n" +
"001011101110\n" +
"011010011011\n" +
"011000001011\n" +
"100000100000\n" +
"001011110110\n" +
"011000100011\n" +
"001010011010\n" +
"000010111111\n" +
"001110001111\n" +
"111110001100\n" +
"010110100011\n" +
"110101100010\n" +
"100111110000\n" +
"010000101011\n" +
"011100011111\n" +
"001100101010\n" +
"101110110100\n" +
"100101000111\n" +
"111111111010\n" +
"000001000001\n" +
"110111011001\n" +
"010011000000\n" +
"101100000101\n" +
"110000100100\n" +
"110100100101\n" +
"101011010010\n" +
"101001000101\n" +
"110001001111\n" +
"010010011010\n" +
"000110110111\n" +
"011010110001\n" +
"001101001001\n" +
"010110101000\n" +
"101000011000\n" +
"110010011010\n" +
"100101011111\n" +
"001101110011\n" +
"110001110001\n" +
"011110000110\n" +
"111011100101\n" +
"001100111001\n" +
"001011011011\n" +
"001011110001\n" +
"010001111101\n" +
"011000101001\n" +
"100100000110\n" +
"011000101111\n" +
"001010110100\n" +
"000100101010\n" +
"111011010110\n" +
"100111000000\n" +
"001000111010\n" +
"101101001111\n" +
"000110111010\n" +
"001111100001\n" +
"011110011001\n" +
"100011000101\n" +
"001010010011\n" +
"110011100110\n" +
"010010001011\n" +
"110101101110\n" +
"111100100101\n" +
"101100100010\n" +
"111010111101\n" +
"000000000011\n" +
"011011001110\n" +
"101110000001\n" +
"000111111000\n" +
"100000110001\n" +
"101101100111\n" +
"001001011001\n" +
"101100010010\n" +
"001000011100\n" +
"111011111100\n" +
"010000100011\n" +
"111010111100\n" +
"011001101111\n" +
"100011001111\n" +
"011001111010\n" +
"110110100101\n" +
"010110100110\n" +
"011110101101\n" +
"011101110001\n" +
"111000100101\n" +
"000010000000\n" +
"100110111001\n" +
"000101000001\n" +
"000001101100\n" +
"011010000100\n" +
"111000101001\n" +
"111100111111\n" +
"100110000110\n" +
"100010001010\n" +
"011110001000\n" +
"100001100100\n" +
"101101101010\n" +
"101111010001\n" +
"010001111100\n" +
"001010111001\n" +
"001101110111\n" +
"010100101100\n" +
"100011011101\n" +
"010100111000\n" +
"000110000000\n" +
"110101101010\n" +
"010100000101\n" +
"101110111100\n" +
"001010110000\n" +
"000000010101\n" +
"000100011000\n" +
"011010110100\n" +
"010000000010\n" +
"111101100011\n" +
"000111101001\n" +
"011101011100\n" +
"101000101101\n" +
"110110101011\n" +
"011010110011\n" +
"011001101010\n" +
"100000000011\n" +
"101001111111\n" +
"111010110100\n" +
"010000011100\n" +
"011011100000\n" +
"110011011000\n" +
"111011101111\n" +
"100010110110\n" +
"010000100111\n" +
"110101110101\n" +
"100010111001\n" +
"011011101000\n" +
"011010000001\n" +
"001001111110\n" +
"100010010001\n" +
"010101000110\n" +
"111111110010\n" +
"101011011110\n" +
"010011110110\n" +
"000010010100\n" +
"100011101111\n" +
"001001110110\n" +
"000100110100\n" +
"100101110110\n" +
"011010111001\n" +
"010010101110\n" +
"110010100011\n" +
"011010101010\n" +
"000101111000\n" +
"111011110011\n" +
"100111101110\n" +
"101111101001\n" +
"010111100010\n" +
"111011001011\n" +
"111110011110\n" +
"110110010110\n" +
"010110010111\n" +
"011111001100\n" +
"110111110010\n" +
"110011111000\n" +
"001110111101\n" +
"111100111000\n" +
"000100000010\n" +
"110101111110\n" +
"010111101101\n" +
"111001001010\n" +
"000010011100\n" +
"110101100100\n" +
"111000011110\n" +
"010110000000\n" +
"011100010011\n" +
"011110010100\n" +
"101000100111\n" +
"111011110101\n" +
"000100010000\n" +
"000110110011\n" +
"100011001011\n" +
"111010100000\n" +
"010100110101\n" +
"001000000101\n" +
"010001101100\n" +
"010110000101\n" +
"100100101111\n" +
"011101111110\n" +
"000011110000\n" +
"000011010011\n" +
"101111111110\n" +
"101001101010\n" +
"000010100011\n" +
"010100101010\n" +
"001111001110\n" +
"011000001001\n" +
"010001110100\n" +
"010111011110\n" +
"100000111111\n" +
"101100010101\n" +
"111101000110\n" +
"110111101111\n" +
"011010010010\n" +
"011100011100\n" +
"001111010010\n" +
"111001101000\n" +
"110110111010\n" +
"101110000111\n" +
"011100101100\n" +
"011100001010\n" +
"110101011101\n" +
"011100010010\n" +
"010101010010\n" +
"000001111101\n" +
"110100110111\n" +
"011111100111\n" +
"111101011110\n" +
"110110000110\n" +
"100110001011\n" +
"111110000001\n" +
"010001010011\n" +
"101001110110\n" +
"011101011101\n" +
"010011011110\n" +
"000100000000\n" +
"100110010001\n" +
"000011100110\n" +
"101111100001\n" +
"101100101010\n" +
"001010101110\n" +
"001111001101\n" +
"110000000111\n" +
"110010100001\n" +
"011100000111\n" +
"100111100111\n" +
"101001011111\n" +
"110000100011\n" +
"111001000111\n" +
"010101111010\n" +
"110111100100\n" +
"001010101100\n" +
"001011110100\n" +
"001010010111\n" +
"110001001000\n" +
"110010011001\n" +
"110111011100\n" +
"001110000011\n" +
"010001000010\n" +
"100000000101\n" +
"110001101001\n" +
"000101010111\n" +
"101010110101\n" +
"100000010000\n" +
"000000111100\n" +
"011011100100\n" +
"110010001110\n" +
"110110100000\n" +
"101100001100\n" +
"110010110111\n" +
"010001100010\n" +
"101110100010\n" +
"001101101101\n" +
"010100110000\n" +
"010010100000\n" +
"011101110100\n" +
"100011011001\n" +
"010110111101\n" +
"010110011011\n" +
"011111011111\n" +
"001000000000\n" +
"001101110101\n" +
"010000010101\n" +
"000101001000\n" +
"011011100101\n" +
"001010000101\n" +
"110010001101\n" +
"000001000011\n" +
"001101001110\n" +
"000101100010\n" +
"010110100001\n" +
"010111110011\n" +
"011000100111\n" +
"100001101011\n" +
"100100100011\n" +
"111100011001\n" +
"010010101000\n" +
"101010000010\n" +
"010011000001\n" +
"100000000010\n" +
"010011101011\n" +
"101110100111\n" +
"111101101011\n" +
"011010001111\n" +
"001000011000\n" +
"011111110111\n" +
"101111011100\n" +
"011011011111\n" +
"110111100010\n" +
"010010110001\n" +
"111100010111\n" +
"111000001111\n" +
"101100010011\n" +
"010101001101\n" +
"110101100001\n" +
"010111010110\n" +
"110000001111\n" +
"000111000000\n" +
"110010010001\n" +
"001110110101\n" +
"101000010010\n" +
"010110001100\n" +
"001101101010\n" +
"110110110110\n" +
"000000000111\n" +
"011010010000\n" +
"011001010111\n" +
"001010101011\n" +
"001001100011\n" +
"001111010110\n" +
"000000100111\n" +
"000000010100\n" +
"001001110011\n" +
"010111000010\n" +
"010000001100\n" +
"101111010111\n" +
"101001110100\n" +
"100011010111\n" +
"000111110100\n" +
"011101111010\n" +
"000111000010\n" +
"011100111100\n" +
"011011110100\n" +
"101000110011\n" +
"010101110111\n" +
"111101101000\n" +
"010010011011\n" +
"000101011111\n" +
"010000000110\n" +
"011110100101\n" +
"111000000100\n" +
"010110110101\n" +
"010110111001\n" +
"101110010000\n" +
"010111001111\n" +
"001001000110\n" +
"010100010000\n" +
"101100100111\n" +
"101100001000\n" +
"110110001001\n" +
"011001001010\n" +
"011001001110\n" +
"110011101001\n" +
"010100101111\n" +
"111101001000\n" +
"100000101100\n" +
"111000011000\n" +
"011000011100\n" +
"111111010001\n" +
"111100100100\n" +
"011000111110\n" +
"010011010000\n" +
"100110101100\n" +
"110000100001\n" +
"001101010011\n" +
"011000101110\n" +
"000110010000\n" +
"011010101100\n" +
"001110001010\n" +
"010101000001\n" +
"101010010101\n" +
"100000010111\n" +
"000100110101\n" +
"110111010110\n" +
"101101101011\n" +
"100101100101\n" +
"101010011110\n" +
"111001000100\n" +
"011101100111\n" +
"010000110101\n" +
"100111010110\n" +
"010011111110\n" +
"111011100100\n" +
"100010101101\n" +
"010110100101\n" +
"100011100000\n" +
"110010011101\n" +
"011110000011\n" +
"111111110011\n" +
"100001101100\n" +
"000000011000\n" +
"000100101101\n" +
"000100110000\n" +
"000110000010\n" +
"011110010011\n" +
"111001111111\n" +
"000011110101\n" +
"111001101100\n" +
"111010111010\n" +
"000101000101\n" +
"111000010110\n" +
"111010011000\n" +
"101110100110\n" +
"111100000100\n" +
"101000110001\n" +
"000001010110\n" +
"101000100000\n" +
"110111001010\n" +
"001001101000\n" +
"010011111010\n" +
"100010100100\n" +
"110010101001\n" +
"111101100101\n" +
"010001000101\n" +
"011001111101\n" +
"110000001110\n" +
"100101101100\n" +
"110110111100\n" +
"010111011101\n" +
"111011011100\n" +
"011111011100\n" +
"100100011001\n" +
"111010011011\n" +
"110011101011\n" +
"100001101000\n" +
"010110100010\n" +
"101100100110\n" +
"010110111010\n" +
"111111011001\n" +
"101011110011\n" +
"011001101001\n" +
"110011100111\n" +
"010100111110\n" +
"001001010011\n" +
"010101110000\n" +
"010111010101\n" +
"100110011100\n" +
"110010011011\n" +
"001011010111\n" +
"000001010100\n" +
"001111011100\n" +
"000010100100\n" +
"010101011011\n" +
"010100001011\n" +
"000001011110\n" +
"011111010111\n" +
"010000101100\n" +
"111111101111\n" +
"100101010110\n" +
"100011010101\n" +
"100101100100\n" +
"010011111101\n" +
"010011001111\n" +
"011010000101\n" +
"110010000111\n" +
"101110110110\n" +
"000010001001\n" +
"111000010010\n" +
"111001001111\n" +
"111000111010\n" +
"010111011100\n" +
"011010001101\n" +
"111011011111\n" +
"001010110001\n" +
"011111111101\n" +
"001001001011\n" +
"100100011000\n" +
"001000101010\n" +
"101001111010\n" +
"011101000010\n" +
"111010000111\n" +
"001000100000\n" +
"100000100010\n" +
"111111011000\n" +
"110011000110\n" +
"111111100010\n" +
"100110011101\n" +
"101111101000\n" +
"001001001100\n" +
"100001100001\n" +
"100111110011\n" +
"001000100010\n" +
"011100011000\n" +
"000001010010\n" +
"100010111110\n" +
"101111010010\n" +
"100100000011\n" +
"000101000010\n" +
"101001011100\n" +
"000101001101\n" +
"000101110010\n" +
"111111111011\n" +
"110100000100\n" +
"000001000010\n" +
"101011010101\n" +
"000011110011\n" +
"000011001000\n" +
"010111111001\n" +
"111110100111\n" +
"100110100111\n" +
"001100001111\n" +
"000100011110\n" +
"001101000101\n" +
"011110000000\n" +
"000100111100\n" +
"011110010111\n" +
"011011010011\n" +
"010101011110\n" +
"100111001100\n" +
"011111101010\n" +
"011011001000\n" +
"100100110100\n" +
"011101010101\n" +
"100101111001\n" +
"100011101001\n" +
"101010000001\n" +
"101110111001\n" +
"110100101111\n" +
"010001001100\n" +
"100110110000\n" +
"100000111001\n" +
"010111011011\n" +
"111110001000\n" +
"101000111101\n" +
"000011010110\n" +
"100010010010\n" +
"010010011111\n" +
"011110111110\n" +
"000100111000\n" +
"111100001101\n" +
"000010110101\n" +
"010010001110\n" +
"101111000100\n" +
"100101111100\n" +
"010100011111\n" +
"110101010010\n" +
"000010111110\n" +
"100001000100\n" +
"001010001010\n" +
"110000111100\n" +
"010000101000\n" +
"111000110110\n" +
"001001101010\n" +
"001101011100\n" +
"001000001100\n" +
"110010011100\n" +
"011111000011\n" +
"111100101101\n" +
"110111010101\n" +
"000010010110\n" +
"111101110111\n" +
"000011010010\n" +
"111110000000\n" +
"001111000101\n" +
"100010111100\n" +
"001011000011\n" +
"010110000010\n" +
"001101111101\n" +
"101011000011\n" +
"100001010010\n" +
"100001010100\n" +
"111100011101\n" +
"010110001101\n" +
"011101101101\n" +
"101010101110\n" +
"110111110100\n" +
"001111001010\n" +
"100010111101\n" +
"011010001001\n" +
"111111001000\n" +
"100010100001\n" +
"111010010110\n" +
"001101000011\n" +
"000011111011\n" +
"110101000100\n" +
"110101111101\n" +
"010010000011\n" +
"110101001111\n" +
"001110111110\n" +
"101111100011\n" +
"011011011100\n" +
"001100100100\n" +
"010011111000\n" +
"101010001111\n" +
"111101010101\n" +
"001110110001\n" +
"101100010100\n" +
"100010001000\n" +
"101110000110\n" +
"001101100001\n" +
"111001000110\n" +
"101110011110\n" +
"100010000110\n" +
"101010111011\n" +
"001010110101\n" +
"001101101110\n" +
"100000101111\n" +
"011001000001\n" +
"010100001110\n" +
"100111101000\n" +
"011000110000\n" +
"110000101111\n" +
"010110111111\n" +
"001110101000\n" +
"111010100010\n" +
"100000110100\n" +
"100100000010\n" +
"101010110011\n" +
"010101000100\n" +
"100100001011\n" +
"000110011011\n" +
"110001000010\n" +
"111111000111\n" +
"010001010010\n" +
"001000011011\n" +
"110010000101\n" +
"111110110111\n" +
"001000111001\n" +
"101111100010\n" +
"101001110010\n" +
"001101101111\n" +
"101001101101\n" +
"001000010011\n" +
"111000011111\n" +
"111111110101\n" +
"101001000001\n" +
"010101101111\n" +
"110100100100\n" +
"001011101011\n" +
"001010111100\n" +
"000111100011\n" +
"010001010100\n" +
"110011000011\n" +
"100111100000\n" +
"001001111001\n" +
"111111100001\n" +
"001001100110\n" +
"001000101001\n" +
"111101011011\n" +
"111000000010\n" +
"100000100111\n" +
"101011100100\n" +
"001010111110\n" +
"100110110100\n" +
"110111100111\n" +
"000110101000\n" +
"011001000111\n" +
"010111000001\n" +
"101111101101\n" +
"000001101101\n" +
"000110100111\n" +
"110001010100\n" +
"111110101111\n" +
"111110110101\n" +
"111000010001\n" +
"101111011010\n" +
"101111110110\n" +
"000000101100\n" +
"010011010010\n" +
"000101010101\n" +
"100110101000\n" +
"000111000011\n" +
"001000010110\n" +
"000111001010\n" +
"000001000111\n" +
"000101000110\n" +
"000100010100\n" +
"001011011101\n" +
"001001111101\n" +
"000000000101\n" +
"000100100101\n" +
"101010001101\n" +
"001010000111\n" +
"110110001110\n" +
"000010011010\n" +
"011001110101\n" +
"111111101011\n" +
"001100001100\n" +
"100111001000\n" +
"011010011000\n" +
"000001101001\n" +
"010001111001\n" +
"001001110100\n" +
"111110111000\n" +
"000010010001\n" +
"111111010011\n" +
"100000011011\n" +
"010110010100\n" +
"010000111000\n" +
"100001110110\n" +
"111101111001\n" +
"110000011010\n" +
"100110101111\n" +
"010001100111\n" +
"100001011100\n" +
"110000010011\n" +
"010100001111\n" +
"110010010110\n" +
"110010111000\n" +
"001011000110\n" +
"101011001101\n" +
"010000000100\n" +
"010010000000\n" +
"010100100101\n" +
"110010100101\n" +
"010101110110\n" +
"101101001101\n" +
"110000110011\n" +
"110011110110\n" +
"111101110110\n" +
"001011111001\n" +
"110101101000\n" +
"101111111100\n" +
"110011111101\n" +
"100001111110\n" +
"011101111000\n" +
"101010000111\n" +
"101110011111\n" +
"101000010101";
        Scanner scan = new Scanner(input);
        
        ArrayList<String> OGR = new ArrayList();
        ArrayList<String> CO2 = new ArrayList();
        int count = 0;
        
        while(scan.hasNext()) {
            String curr = scan.next();
            OGR.add(curr);
            CO2.add(curr);
        }
        
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < OGR.size(); j++) {
                count += digit(OGR.get(j), i);
            }
            if (count >= OGR.size() / 2) {
                for (int j = 0; j < OGR.size(); j++) {
                    if (OGR.size() > 1 && digit(OGR.get(j),i) == 0) {
                        OGR.remove(j);
                    }
                }
            }
            else {
                for (int j = 0; j < OGR.size(); j++) {
                    if (OGR.size() > 1 && digit(OGR.get(j),i) == 1) {
                        OGR.remove(j);
                    }
                }
            }
            
            
            count = 0;
        }
        
        
        for (String i : OGR) {
            System.out.println(i);
        }
        /*
        System.out.print("\n");
        
        for (String i : CO2) {
            System.out.println(i);
        }
        */
    }
    
    private static int digit(String n, int m){
        if (n.charAt(11 - m) == '1') {
            return 1;
        }
        else {
            return 0;
        }
    }
}

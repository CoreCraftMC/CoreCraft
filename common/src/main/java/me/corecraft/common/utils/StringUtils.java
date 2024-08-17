package me.corecraft.common.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.util.Locale;

public class StringUtils {

    /**
     * Converts a {@link Integer} to a {@link String}.
     *
     * @param number number to convert
     * @return {@link String}
     */
    public static String formatInteger(final int number) {
        return NumberFormat.getIntegerInstance(Locale.US).format(number);
    }

    /**
     * Converts a {@link Double} to a {@link String}.
     *
     * @param number number to convert
     * @return {@link String}
     */
    public static String formatDouble(final double number) {
        return NumberFormat.getNumberInstance(Locale.US).format(number);
    }

    /**
     * Converts a {@link JSONObject} to a {@link String}
     *
     * @param jsonObject {@link JSONObject}
     * @return {@link String}
     * @throws JSONException throws exception if it fails
     */
    public static String toString(final JSONObject jsonObject) throws JSONException {
        return jsonObject != null ? toString(jsonObject, false) : null;
    }

    /**
     * Converts {@link JSONObject} to a {@link String}
     *
     * @param jsonObject the {@link JSONObject}
     * @param pretty true or false
     * @return {@link String}
     * @throws JSONException throws exception if it fails
     */
    public static String toString(final JSONObject jsonObject, final boolean pretty) throws JSONException {
        if (jsonObject == null) return null;

        return pretty ? jsonObject.toString(4) : jsonObject.toString();
    }

    /**
     * Converts an array to a {@link String}
     *
     * @param array {@link JSONArray} to convert
     * @return {@link String}
     * @throws JSONException throws exception if it fails
     */
    public static String toString(final JSONArray array) throws JSONException {
        return toString(array, false);
    }

    /**
     * Converts an {@link JSONArray} to a {@link String}
     *
     * @param array the array to convert
     * @param pretty true or false
     * @return {@link String}
     * @throws JSONException throws exception if it fails
     */
    public static String toString(final JSONArray array, final boolean pretty) throws JSONException {
        return pretty ? array.toString(4) : array.toString();
    }

    /**
     * Converts a {@link String} to a {@link JSONObject}
     *
     * @param json the json
     * @return {@link JSONObject}
     * @throws JSONException throws exception if it fails
     */
    public static JSONObject toObject(final String json) throws JSONException {
        return new JSONObject(json);
    }

    /**
     * Converts a {@link String} to a {@link JSONArray}
     *
     * @param json the json
     * @return {@link JSONArray}
     * @throws JSONException throws exception if it fails
     */
    public static JSONArray toArray(final String json) throws JSONException {
        return new JSONArray(json);
    }

    /**
     * Converts a {@link File} into a hash.
     *
     * @param file the file to convert
     * @return {@link String}
     */
    public static String hashFile(final File file) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");

            final byte[] data = Files.readAllBytes(file.toPath());

            digest.update(data);

            return new BigInteger(1, digest.digest()).toString(16);
        } catch (final Exception exception) {
            return null;
        }
    }

    /**
     * Generates a random alphanumeric string
     *
     * @param length the length of the string
     * @return the generated string
     */
    public static String generateString(final int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    /**
     * Generates a random numeric string
     *
     * @param length the length of the string
     * @return the generated string
     */
    public static String generateNumericString(final int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    /**
     * Generates a secure random numeric string
     *
     * @param length the length of the string
     * @return the generated string
     */
    public static String generateSecureString(final int length) {
        return RandomStringUtils.random(length, 0, 0, true, true, null, new SecureRandom());
    }
}
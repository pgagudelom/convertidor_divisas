package com.oraclealura.exchangerateapi;

public record Divisa(String result, String base_code, String target_code, double conversion_rate, double conversion_result) {
}

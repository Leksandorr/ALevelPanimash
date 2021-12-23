package com.alevelhw.hw18.util;

import com.alevelhw.hw18.model.Box;
import com.alevelhw.hw18.model.Cargo;
import com.alevelhw.hw18.model.MaxLiftingCapacity;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoxFromResources {
    private final MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity();
    private final Cargo cargo = new Cargo();
    private final Box box = new Box(maxLiftingCapacity, cargo);
    private Matcher matcher;

    public Box getBox(String fileName, String fileContent) {
        int indexMissingPart;
        String discardPart;
        Pattern pattern = Pattern.compile("\\.xml");
        matcher = pattern.matcher(fileName);
        if (matcher.find()) {
            pattern = Pattern.compile("\".*?\"");
            matcher = pattern.matcher(fileContent);
            indexMissingPart = 1;
            discardPart = "\"";
            matcher.find();
            String garbage = matcher.group();
            matcher.find();
            garbage = matcher.group();

            setFromAndMateriel(indexMissingPart, discardPart);
            setUnitMaxLiftingCapacity(indexMissingPart, discardPart);

            pattern = Pattern.compile(">[^\\s]*?<");
            matcher = pattern.matcher(fileContent);
            discardPart = "<";
            matcher.find();
            garbage = matcher.group();

            setColor(indexMissingPart, discardPart);
            setValueMaxLiftingCapacity(indexMissingPart, discardPart);
            setNameCargo(indexMissingPart, discardPart);
            setClasCargo(indexMissingPart, discardPart);
            setDeliveryDate(indexMissingPart, discardPart);
        }
        else if (Pattern.compile("\\.json").matcher(fileName).find()) {
            pattern = Pattern.compile(": \".*?\"");
            matcher = pattern.matcher(fileContent);
            indexMissingPart = 3;
            discardPart = "\"";

            setFromAndMateriel(indexMissingPart, discardPart);
            setColor(indexMissingPart, discardPart);
            setUnitMaxLiftingCapacity(indexMissingPart, discardPart);
            setNameCargo(indexMissingPart, discardPart);
            setClasCargo(indexMissingPart, discardPart);
            setDeliveryDate(indexMissingPart, discardPart);

            pattern = Pattern.compile(": \\d+ ");
            matcher = pattern.matcher(fileContent);
            indexMissingPart = 2;
            discardPart = " ";

            setValueMaxLiftingCapacity(indexMissingPart, discardPart);
        }
        else {
            throw new IllegalStateException("Unsupported type file");
        }
        return box;
    }

    private String getValueOfField(int indexMissingPart, String discardPart) {
        String value = matcher.group();
        int lastIndex = value.indexOf(discardPart, indexMissingPart);
        return value.substring(indexMissingPart, lastIndex);
    }

    private void setFromAndMateriel (int indexMissingPart, String discardPart) {
        if (matcher.find()) {
            box.setFrom(getValueOfField(indexMissingPart, discardPart));
        } else {
            throw new IllegalStateException("Can not find match for field");
        }
        if (matcher.find()) {
            box.setMaterial(getValueOfField(indexMissingPart, discardPart));
        } else {
            throw new IllegalStateException("Can not find match for field");
        }
    }

    private void setColor (int indexMissingPart, String discardPart) {
        if (matcher.find()) {
            box.setColor(getValueOfField(indexMissingPart, discardPart));
        } else {
            throw new IllegalStateException("Can not find match for field");
        }
    }

    private void setUnitMaxLiftingCapacity (int indexMissingPart, String discardPart) {
        if (matcher.find()) {
            maxLiftingCapacity.setUnit(getValueOfField(indexMissingPart, discardPart));
        } else {
            throw new IllegalStateException("Can not find match for field");
        }
    }

    private void setValueMaxLiftingCapacity (int indexMissingPart, String discardPart) {
        if (matcher.find()) {
            maxLiftingCapacity.setValue(
                    Integer.parseInt(getValueOfField(indexMissingPart, discardPart)));
        } else {
            throw new IllegalStateException("Can not find match for field");
        }
    }

    private void setNameCargo (int indexMissingPart, String discardPart) {
        if (matcher.find()) {
            cargo.setName(getValueOfField(indexMissingPart, discardPart));
        } else {
            throw new IllegalStateException("Can not find match for field");
        }
    }

    private void setClasCargo (int indexMissingPart, String discardPart) {
        if (matcher.find()) {
            cargo.setClas(getValueOfField(indexMissingPart, discardPart));
        } else {
            throw new IllegalStateException("Can not find match for field");
        }
    }

    private void setDeliveryDate (int indexMissingPart, String discardPart) {
        if (matcher.find()) {
            box.setDeliveryDate(
                    LocalDateTime.parse(getValueOfField(indexMissingPart, discardPart)));
        } else {
            throw new IllegalStateException("Can not find match for field");
        }
    }
}

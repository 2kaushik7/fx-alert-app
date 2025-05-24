// screens/CreateAlertScreen.js
import React, { useState } from "react";
import { View, TextInput, Button, StyleSheet, Alert } from "react-native";
import axios from "axios";

export default function CreateAlertScreen() {
  const [pair, setPair] = useState("");
  const [threshold, setThreshold] = useState("");
  const [email, setEmail] = useState("");

  const handleSubmit = () => {
    axios
      .post("http://192.168.0.185:8086/api/alerts", {
        pair: pair.toUpperCase(),
        threshold: parseFloat(threshold),
        email,
      })
      .then(() => {
        Alert.alert("Success", "Alert created!");
        setPair("");
        setThreshold("");
        setEmail("");
      })
      .catch(() => Alert.alert("Error", "Failed to create alert"));
  };

  return (
    <View style={styles.container}>
      <TextInput
        placeholder="Currency Pair (e.g., USDINR)"
        style={styles.input}
        value={pair}
        onChangeText={setPair}
      />
      <TextInput
        placeholder="Threshold Value"
        style={styles.input}
        keyboardType="numeric"
        value={threshold}
        onChangeText={setThreshold}
      />
      <TextInput
        placeholder="Email Address"
        style={styles.input}
        keyboardType="email-address"
        value={email}
        onChangeText={setEmail}
      />
      <Button title="Set Alert" onPress={handleSubmit} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 20 },
  input: { marginBottom: 15, borderBottomWidth: 1, padding: 8, fontSize: 16 },
});

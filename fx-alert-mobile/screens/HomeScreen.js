// screens/HomeScreen.js
import React, { useEffect, useState } from "react";
import { View, Text, FlatList, Button, StyleSheet } from "react-native";
import axios from "axios";

export default function HomeScreen({ navigation }) {
  const [rates, setRates] = useState({});

  useEffect(() => {
    axios
      .get("http://192.168.0.185:8086/api/rates")
      .then((res) => setRates(res.data))
      .catch((err) => console.error(err));
  }, []);

  const renderItem = ({ item }) => (
    <View style={styles.card}>
      <Text style={styles.text}>
        {item[0]}: {item[1]}
      </Text>
    </View>
  );

  return (
    <View style={styles.container}>
      <Button
        title="Create Alert"
        onPress={() => navigation.navigate("Create Alert")}
      />
      <FlatList
        data={Object.entries(rates)}
        keyExtractor={(item) => item[0]}
        renderItem={renderItem}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 20, flex: 1 },
  card: {
    padding: 12,
    marginVertical: 4,
    backgroundColor: "#f0f0f0",
    borderRadius: 8,
  },
  text: { fontSize: 18 },
});

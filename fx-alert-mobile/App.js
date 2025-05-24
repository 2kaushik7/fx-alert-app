import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";

import HomeScreen from "./screens/HomeScreen";
import CreateAlertScreen from "./screens/CreateAlertScreen";

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="FX Rates">
        <Stack.Screen name="FX Rates" component={HomeScreen} />
        <Stack.Screen name="Create Alert" component={CreateAlertScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

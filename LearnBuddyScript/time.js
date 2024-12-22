function getMondayTimestamp_1() {
  const now = new Date();
  const day = now.getDay() ? now.getDay() - 1 : 6;
  const diff = now.getTimezoneOffset() * 60 * 1000;
  const todayZero = new Date(now.getFullYear(), now.getMonth(), now.getDate());
  return todayZero.getTime() - day * 24 * 60 * 60 * 1000 - diff;
}

console.log(getMondayTimestamp_1());
console.log(new Date(getMondayTimestamp_1()).toString());

function getMondayTimestamp() {
  const now = new Date();
  const day = now.getDay() || 7;
  const diff = now.getTimezoneOffset() * 60 * 1000;
  const monday = new Date(
    now.getFullYear(),
    now.getMonth(),
    now.getDate() - day + 1
  );
  return monday.getTime() - diff;
}

console.log(getMondayTimestamp());
console.log(new Date(getMondayTimestamp()).toString());

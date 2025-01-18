# terminal
npm install --save-dev jest typescript ts-jest @types/jest

# jest.config.js
module.exports = {
  preset: 'ts-jest',
  testEnvironment: 'node',
};

# tsconfig.json
{
  "compilerOptions": {
    "typeRoots": [
      "./node_modules/@types"
    ],
    "types": [
      "jest"
    ],
    "esModuleInterop": true
  }
}

# run
npx jest
npx jest solution.test.ts

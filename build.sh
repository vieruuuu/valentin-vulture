rm -rf dist/assets/
cp -r assets/ dist/assets/
javac VV/*.java Main.java -d ./dist/
java -cp dist Main

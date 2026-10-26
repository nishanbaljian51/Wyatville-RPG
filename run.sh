#!/bin/sh
# Compiles and starts Wyatville RPG on Mac or Linux
cd "$(dirname "$0")"

# Use Homebrew's Java if the system one isn't set up
if ! javac -version >/dev/null 2>&1 && [ -x /opt/homebrew/opt/openjdk/bin/javac ]; then
    PATH="/opt/homebrew/opt/openjdk/bin:$PATH"
fi

if ! javac -version >/dev/null 2>&1; then
    echo "Java isn't installed yet. See 'Step 1: Install Java' in README.md."
    exit 1
fi

javac -d bin src/*.java && java -cp bin Game "$@"

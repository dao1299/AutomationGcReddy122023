echo Selected Options: %testcase%

rem Phân tách các giá trị bằng dấu phẩy
for /f "tokens=1* delims=," %%a in ("%testcase%") do (
    echo Processing Option: %%a
    rem Thực hiện lệnh "run xxx.xlsx" với xxx là option
    run %%a.xlsx
)
/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011 SonarSource and Eriks Nukis
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.javascript.model.implementations.statement;

import com.google.common.collect.Iterators;
import com.sonar.sslr.api.AstNode;
import org.sonar.javascript.model.implementations.JavaScriptTree;
import org.sonar.javascript.model.implementations.lexical.InternalSyntaxToken;
import org.sonar.javascript.model.interfaces.Tree;
import org.sonar.javascript.model.interfaces.lexical.SyntaxToken;
import org.sonar.javascript.model.interfaces.statement.StatementTree;
import org.sonar.javascript.model.interfaces.statement.ThrowStatementTree;
import org.sonar.javascript.model.interfaces.statement.WithStatementTree;

import javax.annotation.Nullable;
import java.util.Iterator;

public class WithStatementTreeImpl extends JavaScriptTree implements WithStatementTree {

  private final SyntaxToken withKeyword;
  private final SyntaxToken openingParenthesis;
  private final SyntaxToken closingParenthesis;
  private final StatementTree statement;

  public WithStatementTreeImpl(InternalSyntaxToken withKeyword, InternalSyntaxToken openingParenthesis, AstNode expression, InternalSyntaxToken closingParenthesis, StatementTree statement) {
    super(Kind.WITH_STATEMENT);
    this.withKeyword = withKeyword;
    this.openingParenthesis = openingParenthesis;
    this.closingParenthesis = closingParenthesis;
    this.statement = statement;

    addChild(withKeyword);
    addChild(openingParenthesis);
    addChild(expression);
    addChild(closingParenthesis);
    addChild((AstNode) statement);
  }

  @Override
  public Kind getKind() {
    return Kind.WITH_STATEMENT;
  }

  @Override
  public SyntaxToken withKeyword() {
    return withKeyword;
  }

  @Override
  public SyntaxToken openingParenthesis() {
    return openingParenthesis;
  }

  @Override
  public Tree expression() {
    throw new UnsupportedOperationException("Not supported yet in the strongly typed AST.");
  }

  @Override
  public SyntaxToken closingParenthesis() {
    return closingParenthesis;
  }

  @Override
  public StatementTree statement() {
    return statement;
  }

  @Override
  public Iterator<Tree> childrenIterator() {
    return Iterators.emptyIterator();
  }

}
